package com.LoginJv.demo.autoController;

import com.LoginJv.demo.loginEntity.User;
import com.LoginJv.demo.userService.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    @Autowired
    LoginService service;
    @GetMapping("/")
    public String register(){
        return "Register.html";
    }

    @GetMapping("/Register")
    public String reg(){
        return "Register.html";
    }

    @PostMapping("/Register")
    public String toRegister(@ModelAttribute User user, HttpSession session){
        if(service.find(user.getGmail())!=null){
            return "redirect:/Register?exist=true";
        }
        if(service.find(user.getuName())!=null){
            return "redirect:/Register?userName=true";
        }
        session.setAttribute("success","Successfully Registered!");
        service.register(user);
        return "redirect:/Login";
    }

    @GetMapping("/getMessage")
    @ResponseBody
    public String getMsg(HttpSession session){
        String msg=(String) session.getAttribute("success");
        session.removeAttribute("success");
//        System.out.println(msg);
        return msg!=null?msg:"";
    }
}
