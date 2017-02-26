package ru.ddimike.eschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ddimike.eschool.model.UserLogin;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model p_Model) {
        UserLogin userLogin = new UserLogin();
        p_Model.addAttribute("userLoginData", userLogin);
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("SpringWeb") UserLogin p_userLogin, Model p_Model, HttpSession httpSession) {

        String nextView;
        if("admin".equals(p_userLogin.getLogin()) && "admin".equals(p_userLogin.getPassword())) {
            httpSession.setAttribute("isLoginCorrect", "true");
            nextView = "redirect:/list";
        }
        else {
            p_Model.addAttribute("userLoginData", p_userLogin);
            p_Model.addAttribute("errorLoginMessage", "Неверные логин и пароль!!!");
            nextView = "login";
        }

        return nextView;
    }
}
