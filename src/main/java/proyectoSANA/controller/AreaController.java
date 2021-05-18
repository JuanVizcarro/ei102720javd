package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.AreaDao;
import proyectoSANA.model.Area;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/area")
public class AreaController {
    private List<String> imagenes = new ArrayList<String>();
    private AreaDao areaDao;

    @Autowired
    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    @RequestMapping(value="/add")
    public String addArea(Model model) {
        model.addAttribute("area", new Area());
        return "area/add";
    }

    @RequestMapping("/list")
    public String listArea(Model model) {
        model.addAttribute("areas", areaDao.getAreas());
        return "area/list";
    }

    @RequestMapping("/carrusel")
    public String carrusel(Model model) {
        List<Area> areas = areaDao.getAreas();
        for (Area area:areas){
            imagenes.add(area.getImagen());
        }
        model.addAttribute("imagenes", imagenes);
        return "area/carrusel";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("area") Area area,
                                   BindingResult bindingResult) {
        AreaValidator areaValidator = new AreaValidator();
        areaValidator.validate(area, bindingResult);
        if (bindingResult.hasErrors())
            return "area/add";
        areaDao.addArea(area);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nombre}", method = RequestMethod.GET)
    public String editArea(Model model, @PathVariable String nombre) {
        model.addAttribute("area", areaDao.getArea(nombre));
        return "area/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("area") Area area,
            BindingResult bindingResult) {

        AreaValidator areaValidator = new AreaValidator();
        areaValidator.validate(area, bindingResult);

        if (bindingResult.hasErrors())
            return "area/update";
        areaDao.updateArea(area);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nombre}")
    public String processDelete(@PathVariable String nombre) {
        areaDao.deleteArea(nombre);
        return "redirect:../list";
    }

    @RequestMapping(value="/update/{nombre}", method = RequestMethod.GET)
    public String masInfoArea(Model model, @PathVariable String nombre) {
        model.addAttribute("area", areaDao.getArea(nombre));
        return "area/masInfo";
    }
}
