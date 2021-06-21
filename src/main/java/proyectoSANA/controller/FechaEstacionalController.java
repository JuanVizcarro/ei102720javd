package proyectoSANA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.AreaDao;
import proyectoSANA.dao.FechaEstacionalDao;
import proyectoSANA.dao.ServicioEstacionalDao;
import proyectoSANA.model.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/servicioestacional")
public class FechaEstacionalController {
    private FechaEstacionalDao fechaEstacionalDao;
    private ServicioEstacionalDao servicioEstacionalDao;
    private AreaDao areaDao;

    @Autowired
    public void setAreaDao(AreaDao areaDao) {
        this.areaDao=areaDao;
    }

    @Autowired
    public void setFechaEstacionalDao(FechaEstacionalDao servicioDao) {
        this.fechaEstacionalDao=servicioDao;
    }

    @Autowired
    public void setServicioEstacionalDao(ServicioEstacionalDao servicioDao) {
        this.servicioEstacionalDao=servicioDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/addserv/{nombre}",  method= RequestMethod.GET)
    public String addFechaEstacional(Model model, HttpSession sesion, @PathVariable String nombre) {
        List<ServicioEstacional> serviciosEstacionales = servicioEstacionalDao.getServiciosEstacionales();
        List<String> serviciosList = new ArrayList();
        for (int j = 0; j < serviciosEstacionales.size(); j++) {
            ServicioEstacional z = (ServicioEstacional) serviciosEstacionales.get(j);
            serviciosList.add(z.getNombre());
        }
        FechaEstacional fechest = new FechaEstacional();
        fechest.setArea(nombre);
        model.addAttribute("fechest", fechest);
        model.addAttribute("serviciosestacoinales", serviciosList);
        if (sesion.getAttribute("areafechas") != null) {
            sesion.removeAttribute("areafechas");
        }
        sesion.setAttribute("areafechas", nombre);
        return "servicioestacional/addserv";
    }


//    @RequestMapping("/list")
//    public String listServicio(Model model) {
//        model.addAttribute("serviciosestacionales", servicioFijoDao.getFechasEstacionales());
//        return "servicioestacional/list";
//    }

    @RequestMapping(value="/addserv", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("fechaestacional") FechaEstacional servicioEstacional,
                                   BindingResult bindingResult) {

        fechaEstacionalDao.addServicio(servicioEstacional);
        return "redirect:/servicioestacional/porarea";
    }

    @RequestMapping(value="/porarea")
    public String porArea(Model model, HttpSession sesion) {
        List<FechaEstacional> mis = new ArrayList<>();
        String area = (String) sesion.getAttribute("areafechas");
        List<FechaEstacional> fechas = fechaEstacionalDao.getFechasEstacionales();
        for(FechaEstacional fecha:fechas){
            if(fecha.getArea().equals(area)){
                mis.add(fecha);
            }
        }
        model.addAttribute("fechas", mis);
        return "/servicioestacional/porarea";
    }

//    @RequestMapping(value="/update/{nombre}", method = RequestMethod.GET)
//    public String editServicio(Model model, @PathVariable String nombre) {
//        model.addAttribute("servicioestacional", servicioFijoDao.getServicio(nombre));
//        return "servicioestacional/update";
//    }

//    @RequestMapping(value="/update", method = RequestMethod.POST)
//    public String processUpdateSubmit(
//            @ModelAttribute("servicioestacional") FechaEstacional servicioEstacional,
//            BindingResult bindingResult) {
//
//        ServicioFijoValidator servicioValidator = new ServicioFijoValidator();
//        servicioValidator.validate(servicioEstacional, bindingResult);
//
//        if (bindingResult.hasErrors())
//            return "servicioestacional/update";
//        servicioFijoDao.updateServicio(servicioEstacional);
//        return "redirect:/servicioestacional/list";
//    }

    @RequestMapping(value="/deleteserv/{servicio}/{area}/{fechaini}")
    public String processDelete(@PathVariable("servicio") String servicio, @PathVariable("area") String area, @PathVariable("fechaini") String fechaini, HttpSession sesion, Model model) {
        LocalDate fechain = LocalDate.parse(fechaini);
        fechaEstacionalDao.deleteServicio(servicio,area,fechain);
        List<FechaEstacional> mis = new ArrayList<>();
        List<FechaEstacional> fechas = fechaEstacionalDao.getFechasEstacionales();
        for(FechaEstacional fecha:fechas){
            if(fecha.getArea().equals(area)){
                mis.add(fecha);
            }
        }
        model.addAttribute("fechas", mis);
        return "redirect:/servicioestacional/porarea";
    }
}
