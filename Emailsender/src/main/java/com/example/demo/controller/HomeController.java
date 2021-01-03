package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/emails")
public class HomeController {
	
	@Autowired
	public JavaMailSender jm;
	
	@GetMapping("/sends")
	public String send()
	{
		SimpleMailMessage m=new SimpleMailMessage();
		m.setTo("koundalkaryogesh4@gmail.com");
		m.setSubject("janabae");
		m.setText("sir ahe");
		
		jm.send(m);
		return "send";
		
	}

}
