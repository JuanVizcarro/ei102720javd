package proyectoSANA.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proyectoSANA.dao.PersonalDeControlDao;
import proyectoSANA.model.PersonalDeControl;

@Controller
@RequestMapping("/personaldecontrol")
public class PersonalDeControlController {
    private PersonalDeControlDao personalDeControlDao;

    @Autowired
    public void setPersonalDeControlDao(PersonalDeControlDao personalDeControlDao) {
        this.personalDeControlDao=personalDeControlDao;
    }

    // Operacions: Crear, llistar, actualitzar, esborrar
    // ...
    @RequestMapping(value="/add")
    public String addPersonal(Model model) {
        model.addAttribute("personaldecontrol", new PersonalDeControl());
        return "personaldecontrol/add";
    }


    @RequestMapping("/list")
    public String listPersonal(Model model) {
        model.addAttribute("personalesdecontrol", personalDeControlDao.getPersonal());
        return "personaldecontrol/list";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("personaldecontrol") PersonalDeControl personalDeControl,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "personaldecontrol/add";
        personalDeControlDao.addPersonal(personalDeControl);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{dni}", method = RequestMethod.GET)
    public String editMunicipio(Model model, @PathVariable String dni) {
        model.addAttribute("personaldecontrol", personalDeControlDao.getPersonal(dni));
        return "personaldecontrol/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("perosnaldecontrol") PersonalDeControl personalDeControl,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "personaldecontrol/update";
        personalDeControlDao.updatePersonal(personalDeControl);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{dni}")
    public String processDelete(@PathVariable String dni) {
        personalDeControlDao.deletePersonal(dni);
        return "redirect:../list";
    }

}
