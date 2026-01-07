package com.LoginJv.demo.autoController;

import com.LoginJv.demo.loginEntity.User;
import com.LoginJv.demo.userService.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createAcc")
    public String createAccount(HttpSession session, @RequestParam String otpLab) {
        String email = (String) session.getAttribute("verifiedEmail");
        String otp = (String) session.getAttribute("newOTP");
        Long expiry = (Long) session.getAttribute("otpExpiry");
        if (email == null || otp == null || expiry == null) {
            return "redirect:/Register";
        }
        if (expiry < System.currentTimeMillis()) {
            return "redirect:/otpVerification?expired=true";
        }
        if (!otp.equals(otpLab)) {
            return "redirect:/otpVerification?invalid=true";
        }
        User user = new User();
        user.setuName((String) session.getAttribute("userName"));
        user.setPassword((String) session.getAttribute("password"));
        user.setGmail(email);
        service.register(user);
//        session.invalidate();
        session.removeAttribute("email");
        session.removeAttribute("newOTP");
        session.removeAttribute("otpExpiry");
        session.setAttribute("success","Account created successfully!!");
        return "redirect:/Login?success=true";
    }


    @PostMapping("/Register")
    public String toRegister(@ModelAttribute User user, HttpSession session){
        if(service.find(user.getGmail())!=null){
            return "redirect:/Register?exist=true";
        }
        if(service.find(user.getuName())!=null){
            return "redirect:/Register?userName=true";
        }
        session.setAttribute("verifiedEmail",user.getGmail());
        session.setAttribute("userName",user.getuName());
        session.setAttribute("password",user.getPassword());
        return "redirect:/generateOTP";
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
