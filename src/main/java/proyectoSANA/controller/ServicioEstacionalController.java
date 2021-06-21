package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.ServicioEstacionalDao;
import proyectoSANA.model.ServicioEstacional;

@Controller
@RequestMapping("/servicioestacional")
public class ServicioEstacionalController {
    private ServicioEstacionalDao servicioFijoDao;

    @Autowired
    public void setServicioEstacionalDao(ServicioEstacionalDao servicioDao) {
        this.servicioFijoDao=servicioDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addServico(Model model) {
        model.addAttribute("servicioestacional", new ServicioEstacional());
        return "servicioestacional/add";
    }


    @RequestMapping("/list")
    public String listServicio(Model model) {
        model.addAttribute("serviciosestacionales", servicioFijoDao.getServiciosEstacionales());
        return "servicioestacional/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("servicioestacional") ServicioEstacional servicioEstacional,
                                   BindingResult bindingResult) {

        ServicioEstacionalValidator servicioValidator = new ServicioEstacionalValidator();
        servicioValidator.validate(servicioEstacional, bindingResult);

        if (bindingResult.hasErrors())
            return "servicioestacional/add";
        servicioFijoDao.addServicio(servicioEstacional);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nombre}", method = RequestMethod.GET)
    public String editServicio(Model model, @PathVariable String nombre) {
        model.addAttribute("servicioestacional", servicioFijoDao.getServicio(nombre));
        return "servicioestacional/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("servicioestacional") ServicioEstacional servicioEstacional,
            BindingResult bindingResult) {

        ServicioEstacionalValidator servicioValidator = new ServicioEstacionalValidator();
        servicioValidator.validate(servicioEstacional, bindingResult);

        if (bindingResult.hasErrors())
            return "servicioestacional/update";
        servicioFijoDao.updateServicio(servicioEstacional);
        return "redirect:/servicioestacional/list";
    }

    @RequestMapping(value="/delete/{nombre}")
    public String processDelete(@PathVariable String nombre) {
        servicioFijoDao.deleteServicio(nombre);
        return "redirect:../list";
    }
}
