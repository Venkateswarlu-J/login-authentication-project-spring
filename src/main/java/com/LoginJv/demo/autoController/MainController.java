package com.LoginJv.demo.autoController;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
//    @GetMapping("/Main")
//    public String Main(){
//        return "Main.html";
//    }
    @GetMapping("/Main")
    public String mainPage(HttpSession session){
        return session.getAttribute("userName")==null?"redirect:/Login.html":"Main.html"; // Main.html
    }

    @GetMapping("/header")
    public String header(){
        return "Header.html";
    }

}
