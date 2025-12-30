package com.LoginJv.demo.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String email,String otp){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(email);
//        simpleMailMessage.setText("Your Password Reset OTP is "+otp);
        simpleMailMessage.setText(
                "Hello,\n\n" +
                        "You requested to reset your password.\n\n" +
                        "Your One-Time Password (OTP) is: " + otp + "\n\n" +
                        "This OTP is valid for 10 minutes"
        );
        simpleMailMessage.setSubject("ResetPassword OTP");
        javaMailSender.send(simpleMailMessage);
    }
}
