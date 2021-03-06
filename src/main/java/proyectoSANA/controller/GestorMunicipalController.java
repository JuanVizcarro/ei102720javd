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
import proyectoSANA.dao.GestorMunicipalDao;
import proyectoSANA.dao.MunicipioDao;
import proyectoSANA.model.Ciudadano;
import proyectoSANA.model.GestorMunicipal;
import proyectoSANA.model.Municipio;


@Controller
@RequestMapping("/gestormunicipal")

public class GestorMunicipalController {

    private GestorMunicipalDao gestorMunicipalDao;

    @Autowired
    public void setGestorMunicipalDao(GestorMunicipalDao gestorMunicipalDao) {
        this.gestorMunicipalDao=gestorMunicipalDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addGestorMun(Model model) {
        model.addAttribute("gestormunicipal", new GestorMunicipal());
        return "gestormunicipal/add";
    }


    @RequestMapping("/list")
    public String listGestorMunicipal(Model model) {
        model.addAttribute("gestoresmunicipales", gestorMunicipalDao.getGM());
        return "gestormunicipal/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("gestormunicipal") GestorMunicipal gestorMunicipal,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "gestormunicipal/add";
        gestorMunicipalDao.addGestorMunicipal(gestorMunicipal);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{usuario}", method = RequestMethod.GET)
    public String editGestorMunicipal(Model model, @PathVariable String usuario) {
        model.addAttribute("gestormunicipal", gestorMunicipalDao.getGM(usuario));
        return "gestormunicipal/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("gestormunicipal") GestorMunicipal gestorMunicipal,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "gestormunicipal/update";
        gestorMunicipalDao.updateGestorMun(gestorMunicipal);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{usuario}")
    public String processDelete(@PathVariable String usuario) {
        gestorMunicipalDao.deleteGestorMunicipal(usuario);
        return "redirect:../list";
    }

}
