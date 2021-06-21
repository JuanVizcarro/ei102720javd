package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.ReservaDao;
import proyectoSANA.dao.ServicioFijoDao;
import proyectoSANA.model.Reserva;
import proyectoSANA.model.ServicioFijo;

import java.util.Date;

@Controller
@RequestMapping("/serviciofijo")
public class ServicioFijoController {
    private ServicioFijoDao servicioFijoDao;

    @Autowired
    public void setServicioFijoDao(ServicioFijoDao servicioDao) {
        this.servicioFijoDao=servicioDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addServico(Model model) {
        model.addAttribute("serviciofijo", new ServicioFijo());
        return "serviciofijo/add";
    }


    @RequestMapping("/list")
    public String listServicio(Model model) {
        model.addAttribute("serviciosfijos", servicioFijoDao.getServiciosFijos());
        return "serviciofijo/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("serviciofijo") ServicioFijo servicioFijo,
                                   BindingResult bindingResult) {

        ServicioFijoValidator servicioValidator = new ServicioFijoValidator();
        servicioValidator.validate(servicioFijo, bindingResult);

        if (bindingResult.hasErrors())
            return "serviciofijo/add";
        servicioFijoDao.addServicio(servicioFijo);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nombre}", method = RequestMethod.GET)
    public String editServicio(Model model, @PathVariable String nombre) {
        model.addAttribute("serviciofijo", servicioFijoDao.getServicio(nombre));
        return "serviciofijo/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("serviciofijo") ServicioFijo servicioFijo,
            BindingResult bindingResult) {

        ServicioFijoValidator servicioValidator = new ServicioFijoValidator();
        servicioValidator.validate(servicioFijo, bindingResult);

        if (bindingResult.hasErrors())
            return "serviciofijo/update";
        servicioFijoDao.updateServicio(servicioFijo);
        return "redirect:/serviciofijo/list";
    }

    @RequestMapping(value="/delete/{nombre}")
    public String processDelete(@PathVariable String nombre) {
        servicioFijoDao.deleteServicio(nombre);
        return "redirect:../list";
    }
}
