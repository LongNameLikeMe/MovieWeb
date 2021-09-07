package com.web.movie.controller;

import com.web.movie.entity.User;
import com.web.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(int id, String password, ModelMap map, HttpSession session) {
        User user = userService.loginIn(id, password);
        if (user != null) {
            session.setAttribute("status", "login");
            session.setAttribute("id", user.getId());
            return "index";
        } else {
            map.addAttribute("flag", "yes");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String toLogout(HttpSession session) {
        session.removeAttribute("id");
        session.setAttribute("status", "logout");
        return "index";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "/registerIn", method = RequestMethod.POST)
    public String register(int id, String password, String name, HttpSession session) {
        if (userService.register(id, password, name)) {
            session.setAttribute("status", "login");
            session.setAttribute("id", id);
            return "index";
        } else {
            return "register";
        }
    }

}