package com.LoginJv.demo.autoController;


import com.LoginJv.demo.feedbackDAO.FeedBackService;
import com.LoginJv.demo.loginEntity.Feedback;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class FeedBackController {

    @Autowired
    FeedBackService feedBackService;
    @GetMapping("/FeedBack")
    public String fedPage(HttpSession session){
        return session.getAttribute("userName")==null?"redirect:/Login.html":"FeedBack.html";
    }

    @GetMapping("/About")
    public String aboutPage(HttpSession session){
        System.out.println(session.getAttribute("userName"));
        return session.getAttribute("userName")==null?"redirect:/Login.html":"About.html";
    }

    @PostMapping("/feedback")
    public String save(@RequestParam String message, HttpSession session){
        Feedback fed=new Feedback();
        fed.setGmail(session.getAttribute("email").toString());
        fed.setUserName(session.getAttribute("userName").toString());
        fed.setMsg(message);
        fed.setDate(new Date());
        feedBackService.insert(fed);
        session.setAttribute("success","Thank you for your valuable feedback!");
        return "redirect:/FeedBack";
    }
}
