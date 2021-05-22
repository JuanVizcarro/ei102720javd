package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.GestorMedioambientalDao;
import proyectoSANA.model.GestorMedioambiental;


@Controller
@RequestMapping("/gestormedioambiental")

public class GestorMedioambientalController {

    private GestorMedioambientalDao gestorMedioambientalDao;

    @Autowired
    public void setGestorMedioambientalDao(GestorMedioambientalDao gestorMedioambientalDao) {
        this.gestorMedioambientalDao=gestorMedioambientalDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addGestorMedioambiental(Model model) {
        model.addAttribute("gestormedioambiental", new GestorMedioambiental());
        return "gestormedioambiental/add";
    }


    @RequestMapping("/list")
    public String listGestorMedioambiental(Model model) {
        model.addAttribute("gestoresmedioambientales", gestorMedioambientalDao.getGM());
        return "gestormedioambiental/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("gestormedioambiental") GestorMedioambiental gestorMedioambiental,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "gestormedioambiental/add";
        gestorMedioambientalDao.addGestorMedioambiental(gestorMedioambiental);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{usuario}", method = RequestMethod.GET)
    public String editGestorMedioambiental(Model model, @PathVariable String usuario) {
        model.addAttribute("gestormedioambiental", gestorMedioambientalDao.getGM(usuario));
        return "gestormedioambiental/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("gestormedioambiental") GestorMedioambiental gestorMedioambiental,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "gestormedioambiental/update";
        gestorMedioambientalDao.updateGestorMedioambiental(gestorMedioambiental);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{usuario}")
    public String processDelete(@PathVariable String usuario) {
        gestorMedioambientalDao.deleteGestorMedioambiental(usuario);
        return "redirect:../list";
    }

}
