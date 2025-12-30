package com.LoginJv.demo.autoController;


import com.LoginJv.demo.loginEntity.User;
import com.LoginJv.demo.userService.LoginService;
import com.LoginJv.demo.userService.MailService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginService service;

    @GetMapping("/Login")
    public String loginPage(HttpSession session) {
//        System.out.println("log:"+(session.getAttribute("userName") != null));
        if (session.getAttribute("userName") != null) {
            return "redirect:/Main";
        }
        return "Login.html";
    }
/*
    @GetMapping("/Login")
    public String login(){
        return "Login.html";
    }*/

    @PostMapping("/Login")
    public String loginUser(
        @RequestParam String identity,
        @RequestParam String pass,
        HttpSession session) {
//        System.out.println(session.getAttribute("userName")!=null);
        if(session.getAttribute("userName")!=null) return "redirect:/Main";

//        System.out.println("Entered into login");
        User user = service.authenticateUser(identity, pass);
//        System.out.println(isValid);
        if (user != null) {
            session.setAttribute("userName", user.getuName());
            session.setAttribute("email",identity);
            return "redirect:/Main";
        }
//        model.addAttribute("loginError","Incorrect pass or email..");
        return "redirect:/Login?error=true";
    }

    @GetMapping("/getEmail")
    @ResponseBody
    public String getEmail(HttpSession session){
        return session.getAttribute("email").toString();
    }

}
