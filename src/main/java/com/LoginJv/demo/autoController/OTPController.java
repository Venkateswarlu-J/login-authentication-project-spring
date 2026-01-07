package com.LoginJv.demo.autoController;


import com.LoginJv.demo.userService.LoginService;
import com.LoginJv.demo.userService.MailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OTPController {
    @Autowired
    LoginService service;
    @Autowired
    MailService mailService;

    @PostMapping("/validate-OTP")
    public String validate(@RequestParam String email, @RequestParam String otp, HttpSession httpSession){
        String actualOtp=(String)httpSession.getAttribute("newOTP");
        long expiry=(long)httpSession.getAttribute("otpExpiry");
        if(expiry<System.currentTimeMillis()){
            return "redirect:/ForgetPass?expire-otp=true";
        }
        else if(!actualOtp.equals(otp)){
            return "redirect:/ForgetPass?wrong-otp=true";
        }
        return "redirect:/ResetPass";
    }

    @GetMapping("/generateOTP")
    public String genOtp(HttpSession session){
        System.out.println("hello");
        String email=session.getAttribute("verifiedEmail").toString();
        if (email == null) return "redirect:/Register";
        String otp=service.generateOtp();
        mailService.send(email,otp);
        session.setAttribute("newOTP",otp);
        session.setAttribute("otpExpiry", System.currentTimeMillis()+(10*60*1000));
        session.setAttribute("success","OTP Sended successfully to"+email);
        return "redirect:/otpVerification?otp=true";
    }

    @GetMapping("/otpVerification")
    public String otpVer(HttpSession session){
        if((String)session.getAttribute("verifiedEmail")!=null){
            return "otpVerification.html";
        }
        return "Register.html";
    }

//    @PostMapping("/otpVerification")
//    public String otpVer(@RequestParam String gmail,String uName,String password, HttpSession session){
//        if(session.getAttribute("verifiedEmail").toString()!=null){
//            return "otpVerification.html";
//        }
//        return "Register.html";
//    }

}
