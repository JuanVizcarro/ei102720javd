package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.MunicipioDao;
import proyectoSANA.model.Municipio;
import proyectoSANA.model.UserDetails;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/municipio")
public class MunicipioController {

    private MunicipioDao municipioDao;

    @Autowired
    public void setMunicipioDao(MunicipioDao municipioDao) {
        this.municipioDao=municipioDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addMunicipio(Model model) {
        model.addAttribute("municipio", new Municipio());
        return "municipio/add";
    }


    @RequestMapping("/list")
    public String listMunicipios(Model model, HttpSession sesion) {
        model.addAttribute("municipios", municipioDao.getMunicipios());
        if (sesion.getAttribute("medioambiente") != null) {
            return "municipio/list";
        }
        return "municipio/listciu";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("municipio") Municipio municipio,
                                   BindingResult bindingResult) {
        MunicipioValidator municipioValidator = new MunicipioValidator();
        municipioValidator.validate(municipio, bindingResult);
        if (bindingResult.hasErrors())
            return "municipio/add";
        municipioDao.addMunicipio(municipio);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nombre}", method = RequestMethod.GET)
    public String editMunicipio(Model model, @PathVariable String nombre) {
        model.addAttribute("municipio", municipioDao.getMunicipio(nombre));
        return "municipio/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("municipio") Municipio municipio,
            BindingResult bindingResult) {
        MunicipioValidator municipioValidator = new MunicipioValidator();
        municipioValidator.validate(municipio, bindingResult);
        if (bindingResult.hasErrors())
            return "municipio/update";
        municipioDao.updateMunicipio(municipio);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nombre}")
    public String processDelete(@PathVariable String nombre) {
        municipioDao.deleteMunicipio(nombre);
        return "redirect:../list";
    }

}
