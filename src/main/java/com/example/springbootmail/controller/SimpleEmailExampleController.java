package com.example.springbootmail.controller;

import com.example.springbootmail.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleEmailExampleController {
    @Autowired
    public JavaMailSender emailSender;

    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {

        // Ստեղծեք պարզ փոստի հաղորդագրություն:
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Պարզ էլ.փոստի փորձարկում");
        message.setText("Բարև, ես փորձարկում եմ պարզ էլփոստը");

        // Ուղարկել հաղորդագրություն!
        this.emailSender.send(message);

        return "Email Ուղարկված է!";
    }
}
