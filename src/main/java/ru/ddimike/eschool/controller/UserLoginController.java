package ru.ddimike.eschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ddimike.eschool.model.UserLogin;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    @GetMapping("/")
    public String login(Model model) {
        UserLogin userLogin = new UserLogin();
        model.addAttribute("userLoginData", userLogin);
        return "login";
    }

    @PostMapping("/")
    public String checkLogin(@ModelAttribute("userLoginData") UserLogin userLogin, Model model, HttpSession httpSession) {

        String nextView;
        if("admin".equals(userLogin.getLogin()) && "admin".equals(userLogin.getPassword())) {
            httpSession.setAttribute("isLoginCorrect", "true");
            nextView = "redirect:/list";
        }
        else {
            model.addAttribute("userLoginData", userLogin);
            model.addAttribute("errorLoginMessage", "Неверные логин и пароль!!!");
            nextView = "login";
        }

        return nextView;
    }
}
