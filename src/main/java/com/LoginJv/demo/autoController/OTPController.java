package com.LoginJv.demo.autoController;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OTPController {

    @PostMapping("/validate-OTP")
    public String validate(@RequestParam String email, @RequestParam String otp, HttpSession httpSession){
        String actualOtp=httpSession.getAttribute("newOTP").toString();
        long expiry=(long)httpSession.getAttribute("otpExpiry");
        if(expiry<System.currentTimeMillis()){
            return "redirect:/ForgetPass?expire-otp=true";
        }
        else if(!actualOtp.equals(otp)){
            return "redirect:/ForgetPass?wrong-otp=true";
        }
        return "redirect:/ResetPass";
    }

}
