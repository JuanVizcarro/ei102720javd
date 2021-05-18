package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.CiudadanoDao;
import proyectoSANA.dao.MunicipioDao;
import proyectoSANA.model.Ciudadano;
import proyectoSANA.model.Municipio;


@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {

    private CiudadanoDao ciudadanoDao;

    @Autowired
    public void setCiudadanoDao(CiudadanoDao ciudadanoDao) {
        this.ciudadanoDao=ciudadanoDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addCiudadano(Model model) {
        model.addAttribute("ciudadano", new Ciudadano());
        return "ciudadano/add";
    }


    @RequestMapping("/list")
    public String listCiudadano(Model model) {
        model.addAttribute("ciudadanos", ciudadanoDao.getCiudadanos());
        return "ciudadano/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("ciudadano") Ciudadano ciudadano,
                                   BindingResult bindingResult) {
        CiudadanoValidator ciudadanoValidator = new CiudadanoValidator();
        ciudadanoValidator.validate(ciudadano, bindingResult);
        if (bindingResult.hasErrors())
            return "ciudadano/add";
        ciudadanoDao.addCiudadano(ciudadano);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{usuario}", method = RequestMethod.GET)
    public String editCiudadano(Model model, @PathVariable String usuario) {
        model.addAttribute("ciudadano", ciudadanoDao.getCiudadano(usuario));
        return "ciudadano/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("ciudadano") Ciudadano ciudadano,
            BindingResult bindingResult) {
        CiudadanoValidator ciudadanoValidator = new CiudadanoValidator();
        ciudadanoValidator.validate(ciudadano, bindingResult);
        if (bindingResult.hasErrors())
            return "ciudadano/update";
        ciudadanoDao.updateCiudadano(ciudadano);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{usuario}")
    public String processDelete(@PathVariable String usuario) {
        ciudadanoDao.deleteCiudadano(usuario);
        return "redirect:../list";
    }

}
