package proyectoSANA.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import proyectoSANA.dao.UserDao;
import proyectoSANA.model.UserDetails;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserDao userDao;

    @Autowired
    public void setSociDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/list")
    public String listSocis(HttpSession session, Model model) {
        session.setAttribute("nexturl", "/user/list");
        if (session.getAttribute("user") == null)
        {
            model.addAttribute("user", new UserDetails());
            return "login";
        }
         if (session.getAttribute("ciudadano") == null)
        {
            model.addAttribute("ciudadano", new UserDetails());
            return "ciudadano/list";
        }
        if (session.getAttribute("ciudadano") == null)
        {
            model.addAttribute("municipal", new UserDetails());
            return "gestormunicipal/list";
        }

        model.addAttribute("users", userDao.listAllUsers());
        return "user/list";
    }
}

