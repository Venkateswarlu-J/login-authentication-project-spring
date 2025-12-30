package com.LoginJv.demo.autoController;

import com.LoginJv.demo.loginEntity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogoutController {


    @GetMapping("/Logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/Login";
    }

    @GetMapping("/username")
    @ResponseBody
    public String user(HttpSession session){
        return session.getAttribute("userName").toString();
    }
}
