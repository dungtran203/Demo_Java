package com.foly.assignment.controller.admin;

import com.foly.assignment.service.MailerService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailerController {
	@Autowired
    MailerService mailer;

@ResponseBody
@RequestMapping("/mailer/demo1")
	public String demo1(Model model){
		try {
            mailer.send("dungttmph25136@fpt.edu.vn", "Subject", "Body");
			return "OK";
		} catch (MessagingException e) {
			return e.getMessage();
		}
	}
}