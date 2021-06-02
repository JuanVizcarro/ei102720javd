package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.AreaDao;
import proyectoSANA.dao.ReservaDao;
import proyectoSANA.dao.ZonaDao;
import proyectoSANA.model.Area;
import proyectoSANA.model.Reserva;
import proyectoSANA.model.UserDetails;
import proyectoSANA.model.Zona;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
    private ReservaDao reservaDao;
    private AreaDao areaDao;
    private ZonaDao zonaDao;
    String nombre;

    @Autowired
    public void setZonaDao(ZonaDao zonaDao) {
        this.zonaDao = zonaDao;
    }

    @Autowired
    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    @Autowired
    public void setReservaDao(ReservaDao reservaDao) {
        this.reservaDao=reservaDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add/{area}", method= RequestMethod.GET)
    public String addReserva(Model model, @PathVariable String area, HttpSession sesion) {
        sesion.setAttribute("nexturl","/reserva/add/"+area);
        Reserva res = new Reserva();
        model.addAttribute("area", areaDao.getArea(area));
        nombre = area;
        if (sesion.getAttribute("ciudadano") == null)
        {
            model.addAttribute("user", new UserDetails());
            return "redirect:/login";
        }
        UserDetails us = (UserDetails) sesion.getAttribute("ciudadano");
        res.setPersona(us.getDni());
        double i = Math.random()*999999999;
        int in= (int) i;
        String st = in + "654328";
        res.setNumeroReserva(st);
        model.addAttribute("reserva", res);
        List zonas = zonaDao.getZonas();
        List zonaList = new ArrayList();
        for (int j = 0; j < zonas.size(); j++) {
            Zona z = (Zona) zonas.get(j);
            if (z.getArea().equals(area)){
                zonaList.add(z.getNumero());
            }
        }
        model.addAttribute("zonaList", zonaList);
        return "reserva/add";
    }


    @RequestMapping("/list")
    public String listReserva(Model model) {
        model.addAttribute("reservas", reservaDao.getReservas());
        return "reserva/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("reserva") Reserva reserva,
                                   BindingResult bindingResult, HttpSession sesion) {
        reserva.setArea(nombre);
        ReservaValidator reservaValidator = new ReservaValidator();
        reservaValidator.validate(reserva, bindingResult);

        if (bindingResult.hasErrors())
            return "reserva/add";
        reservaDao.addReserva(reserva);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{numeroReserva}", method = RequestMethod.GET)
    public String editReserva(Model model, @PathVariable String numeroReserva) {
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

    @RequestMapping(value="/delete/{numeroReserva}")
    public String processDelete(@PathVariable String numeroReserva) {
        reservaDao.deleteReserva(numeroReserva);
        return "redirect:../list";
    }
}
