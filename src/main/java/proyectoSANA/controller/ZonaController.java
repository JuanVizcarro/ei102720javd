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
import proyectoSANA.dao.ZonaDao;
import proyectoSANA.model.Ciudadano;
import proyectoSANA.model.GestorMunicipal;
import proyectoSANA.model.Municipio;
import proyectoSANA.model.Zona;

@Controller
@RequestMapping("/zona")

public class ZonaController {

    private ZonaDao zonaDao;

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
        if (bindingResult.hasErrors())
            return "zona/add";
        zonaDao.addZona(zona);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{numero}")
    public String processDelete(@PathVariable int numero) {
        zonaDao.deleteZona(numero);
        return "redirect:../list";
    }
}
