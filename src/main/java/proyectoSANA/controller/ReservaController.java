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
import proyectoSANA.model.Reserva;

import java.util.Date;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
    private ReservaDao reservaDao;

    @Autowired
    public void setReservaDao(ReservaDao reservaDao) {
        this.reservaDao=reservaDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reserva/add";
    }


    @RequestMapping("/list")
    public String listReserva(Model model) {
        model.addAttribute("reservas", reservaDao.getReservas());
        return "reserva/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("reserva") Reserva reserva,
                                   BindingResult bindingResult) {

        ReservaValidator reservaValidator = new ReservaValidator();
        reservaValidator.validate(reserva, bindingResult);

        if (bindingResult.hasErrors())
            return "reserva/add";
        reservaDao.addReserva(reserva);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nombre}", method = RequestMethod.GET)
    public String editReserva(Model model, @PathVariable int numeroReserva) {
        model.addAttribute("reserva", reservaDao.getReserva(numeroReserva));
        return "reserva/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("reserva") Reserva reserva,
            BindingResult bindingResult) {

        ReservaValidator reservaValidator = new ReservaValidator();
        reservaValidator.validate(reserva, bindingResult);

        if (bindingResult.hasErrors())
            return "reserva/update";
        reservaDao.updateReserva(reserva);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nombre}")
    public String processDelete(@PathVariable int numeroReserva) {
        reservaDao.deleteReserva(numeroReserva);
        return "redirect:../list";
    }
}
