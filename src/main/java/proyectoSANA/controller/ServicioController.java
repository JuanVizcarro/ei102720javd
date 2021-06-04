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
import proyectoSANA.dao.ServicioDao;
import proyectoSANA.model.Reserva;
import proyectoSANA.model.Servicio;

import java.util.Date;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
    private ServicioDao servicioDao;

    @Autowired
    public void setServicioDao(ServicioDao servicioDao) {
        this.servicioDao=servicioDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addServico(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicio/add";
    }


    @RequestMapping("/list")
    public String listServicio(Model model) {
        model.addAttribute("servicios", servicioDao.getServicios());
        return "servicio/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("servicio") Servicio servicio,
                                   BindingResult bindingResult) {

        ServicioValidator servicioValidator = new ServicioValidator();
        servicioValidator.validate(servicio, bindingResult);

        if (bindingResult.hasErrors())
            return "servicio/add";
        servicioDao.addServicio(servicio);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{identificador}", method = RequestMethod.GET)
    public String editServicio(Model model, @PathVariable String identificador) {
        System.out.println(identificador);
        model.addAttribute("servicio", servicioDao.getServicio(identificador));
        return "servicio/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("servicio") Servicio servicio,
            BindingResult bindingResult) {

        ServicioValidator servicioValidator = new ServicioValidator();
        servicioValidator.validate(servicio, bindingResult);

        if (bindingResult.hasErrors())
            return "servicio/update";
        servicioDao.updateServicio(servicio);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{identificador}")
    public String processDelete(@PathVariable String identificador) {
        servicioDao.deleteServicio(identificador);
        return "redirect:../list";
    }
}
