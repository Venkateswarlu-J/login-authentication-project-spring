package com.LoginJv.demo.autoController;

import com.LoginJv.demo.userService.LoginService;
import com.LoginJv.demo.userService.MailService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordHandler {
    @Autowired
    LoginService service;
    @Autowired
    MailService mailService;

    @GetMapping("ResetPass")
    public String reset(HttpSession session){
        return session.getAttribute("userName")!=null?"ResetPass.html":"redirect:/Login";
    }

    @GetMapping("/ForgetPass")
    public String forget_pass(HttpSession session){
        return session.getAttribute("userName")!=null?"ForgetPass.html":"redirect:/Login";
    }

    @PostMapping("reset-password")
    @Transactional
    public String reset(@RequestParam String newPass, HttpSession session){
        System.out.println(session.getAttribute("email").toString());
        service.update(session.getAttribute("email").toString(),newPass);
        session.setAttribute("success","Password changed successfully!");
        return "redirect:/Login";
    }

    @PostMapping("/forget-password")
    public String forget_pass(@RequestParam String email, HttpSession session){
        if(service.find(email)==null){
            return "redirect:/ForgetPass?notFound=true";
        }
        String otp=service.generateOtp();
        mailService.send(email,otp);
        session.setAttribute("email",email);
        session.setAttribute("newOTP",otp);
        session.setAttribute("otpExpiry", System.currentTimeMillis()+(10*60*1000));
        session.setAttribute("success","OTP sent Successfully to "+email);
        return "redirect:/ForgetPass?otp=true";
    }

}
