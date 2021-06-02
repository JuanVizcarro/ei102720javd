package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.*;
import proyectoSANA.model.*;

@Controller
@RequestMapping("/zona")

public class ZonaController {

    private ZonaDao zonaDao;
    private AreaDao areaDao;
    private Area area;

    @Autowired
    public void setZonaDao(ZonaDao zonaDao) {
        this.zonaDao=zonaDao;
    }

    @RequestMapping(value="/add")
    public String addzona(Model model) {
        model.addAttribute("zona", new Zona());
        return "zona/add";
    }


    @RequestMapping("/list")
    public String listZona(Model model) {
        model.addAttribute("zonas", zonaDao.getZonas());
        return "zona/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("zona") Zona zona,
                                   BindingResult bindingResult) {
        ZonaValidator zonaValidator = new ZonaValidator();
        zonaValidator.validate(zona, bindingResult);

        if (bindingResult.hasErrors())
            return "zona/add";
        zonaDao.addZona(zona);
//        System.out.println(areaDao.getArea(zona.getArea()).toString());
//        area = areaDao.getArea(zona.getArea());
//        area.getZonaList().add(zona.getNumero());
//        System.out.println(area.getZonaList().toString());
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{numero}")
    public String processDelete(@PathVariable int numero) {
        zonaDao.deleteZona(numero);
        return "redirect:../list";
    }
}
