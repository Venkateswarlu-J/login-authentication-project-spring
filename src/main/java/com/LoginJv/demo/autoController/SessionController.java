package com.LoginJv.demo.autoController;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {

    @GetMapping("/session-status")
    @ResponseBody
    public boolean sesStat(HttpSession session){
        return session.getAttribute("userName")!=null;
    }
}
