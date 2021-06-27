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
import proyectoSANA.dao.ReservaDao;
import proyectoSANA.dao.ServicioFijoDao;
import proyectoSANA.model.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/area")
public class AreaController {
    private AreaDao areaDao;
    private ReservaDao reservaDao;
    private ServicioFijoDao servicioFijoDao;
    private FechaEstacionalDao fechaEstacionalDao;

    @Autowired
    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    @Autowired
    public void setFechaDao(FechaEstacionalDao areaDao) {
        this.fechaEstacionalDao = areaDao;
    }

    @Autowired
    public void setRaservaDao(ReservaDao reservaDao) {
        this.reservaDao = reservaDao;
    }

    @Autowired
    public void setServicioFijoDao(ServicioFijoDao servicioDao) {
        this.servicioFijoDao = servicioDao;
    }

    @RequestMapping(value="/add")
    public String addArea(Model model) {
        model.addAttribute("area", new Area());
        return "area/add";
    }

    @RequestMapping("/list")
    public String listArea(Model model, HttpSession sesion) {
        if (sesion.getAttribute("municipal") != null)
        {
            model.addAttribute("areas", areaDao.getAreas());
            return "area/list";
        }
        return "redirect:/area/carrusel";
    }

    @RequestMapping("/carrusel")
    public String carrusel(Model model) {
        List<String> imagenes = new ArrayList<String>();
        List<Area> areas = areaDao.getAreas();
        model.addAttribute("area", areas);
        for (Area area:areas){
            imagenes.add(area.getImagen());
        }
        model.addAttribute("imagenes", imagenes);
        return "area/carrusel";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("area") Area area,
                                   BindingResult bindingResult) {
        AreaValidator areaValidator = new AreaValidator();
        areaValidator.validate(area, bindingResult);
        if (bindingResult.hasErrors())
            return "area/add";
        areaDao.addArea(area);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nombre}", method = RequestMethod.GET)
    public String editArea(Model model, @PathVariable String nombre) {
        model.addAttribute("area", areaDao.getArea(nombre));
        return "area/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("area") Area area,
            BindingResult bindingResult) {

        AreaValidator areaValidator = new AreaValidator();
        areaValidator.validate(area, bindingResult);

        if (bindingResult.hasErrors())
            return "area/update";
        areaDao.updateArea(area);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{nombre}")
    public String processDelete(@PathVariable String nombre) {
        areaDao.deleteArea(nombre);
        return "redirect:../list";
    }

    @RequestMapping(value="/masInfo/{nombre}", method = RequestMethod.GET)
    public String masInfoArea(Model model, @PathVariable String nombre) {
        Set<String> list = new HashSet<>();
        List<FechaEstacional> mis = new ArrayList<>();
        List<FechaEstacional> fechas = fechaEstacionalDao.getFechasEstacionales();
        for(FechaEstacional fecha:fechas){
            if(fecha.getArea().equals(nombre)){
                mis.add(fecha);
            }
        }
        for (FechaEstacional f : mis) {
            list.add(f.getServicio());
        }
        String g = "";
        for (String f : list){
            g += f + " ";
        }
        model.addAttribute("FechaEstacionales", g);
        model.addAttribute("area", areaDao.getArea(nombre));
        return "area/masInfo";
    }

    @RequestMapping("/panel")
    public String panel(Model model) {
        return "area/panel";
    }

    @RequestMapping(value="/addServiciofijo/{nombre}", method= RequestMethod.GET)
    public String addServiciofijo(Model model, HttpSession sesion, @PathVariable String nombre) {
        List<ServicioFijo> serviciosFijos = servicioFijoDao.getServiciosFijos();
        List<String> serviciosList = new ArrayList();
        for (int j = 0; j < serviciosFijos.size(); j++) {
            ServicioFijo z = (ServicioFijo) serviciosFijos.get(j);
            serviciosList.add(z.getNombre());
        }
        model.addAttribute("serviciosfijos", serviciosList);
        model.addAttribute("area", areaDao.getArea(nombre));
        String g = areaDao.getArea(nombre).getCaracteristicaFisica() + " ";
        //sesion.setAttribute("g", g);
        return "area/addServiciofijo";
    }

    @RequestMapping(value="/addServiciofijo", method= RequestMethod.POST)
    public String AddServiciofijoSubmit(@ModelAttribute("area") Area area,  HttpSession sesion) {
//        String g = (String) sesion.getAttribute("g");
//        area.setCaracteristicaFisica(g + area.getCaracteristicaFisica());
        areaDao.updateArea(area);
//        sesion.removeAttribute("g");
        return "redirect:/area/list";
    }

    @RequestMapping(value="/ocupacion/{nombre}", method = RequestMethod.GET)
    public String OcupacionArea(Model model, @PathVariable String nombre, HttpSession sesion) {
        nombre = nombre;
        Ocupacion x = new Ocupacion();
        model.addAttribute("x", x);
        sesion.setAttribute("nombre",nombre);
        return "area/ocupacion";
    }

    @RequestMapping(value="/ocupacion", method= RequestMethod.POST)
    public String PostOcupacion(Model model, HttpSession sesion, @ModelAttribute("x") Ocupacion x) {
        x = (Ocupacion) model.getAttribute("x");
        sesion.setAttribute("fech",x);
        return "redirect:/area/ocfin";
    }

    @RequestMapping("/ocfin")
    public String OcFin(Model model, HttpSession sesion) {
        String area = (String) sesion.getAttribute("nombre");
        Ocupacion x = (Ocupacion) sesion.getAttribute("fech");
        x.setArea(area);
        x.setNormal(reservaDao.getOcupacion(area, x.getFecha()));
        model.addAttribute("dato", x);
        sesion.removeAttribute("fech");
        sesion.removeAttribute("nombre");
        return "area/ocfin";
    }

    }
