package es.uji.ei1027.clubesportiu.controller;

import es.uji.ei1027.clubesportiu.services.ClassificacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.clubesportiu.dao.ClassificacioDao;
import es.uji.ei1027.clubesportiu.model.Classificacio;


@Controller
@RequestMapping("/classificacio")
public class ClassificacioController {

    private ClassificacioDao classificacioDao;

    @Autowired
    public void setNadadorDao(ClassificacioDao classificacioDao) {
        this.classificacioDao=classificacioDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addClasificacio(Model model) {
        model.addAttribute("classificacio", new Classificacio());
        return "classificacio/add";
    }


    @RequestMapping("/list")
    public String listClassificacions(Model model) {
        model.addAttribute("classificacions", classificacioDao.getClassificacions());
        return "classificacio/list";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("classificacio") Classificacio classificacio,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "classificacio/add";
        classificacioDao.addClassificacio(classificacio);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{nomNadador}/{nomProva}", method = RequestMethod.GET)
    public String processUpdateClassif(Model model, @PathVariable String nomNadador,
                                       @PathVariable String nomProva) {
        model.addAttribute("classificacio", classificacioDao.getClassificacio(nomNadador, nomProva));
        return "classificacio/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("classificacio") Classificacio classificacio,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "classificacio/update";
        classificacioDao.updateClassificacio(classificacio);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{nomNadador}/{nomProva}")
    public String processDeleteClassif(@PathVariable String nomNadador,
                                       @PathVariable String nomProva) {
        classificacioDao.deleteClassificacio(nomNadador, nomProva);
        return "redirect:../../list";
    }

    private ClassificacioService classificacioService;

    @Autowired
    public void setClassificacioService(ClassificacioService                                                classificacioService) {
        this.classificacioService = classificacioService;
    }

    @RequestMapping(value = "/perpais/{nomProva}")
    public String listClsfPerPais(Model model, @PathVariable String nomProva) {
        model.addAttribute("classificacions",
                classificacioService.getClassificationByCountry(nomProva));
        return "classificacio/perpais";
    }



}