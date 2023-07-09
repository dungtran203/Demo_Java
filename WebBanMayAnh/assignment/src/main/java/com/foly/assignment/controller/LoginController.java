package com.foly.assignment.controller;

import com.foly.assignment.dao.LoginDao;
import com.foly.assignment.entity.Account;
import com.foly.assignment.service.AccountService;
import com.foly.assignment.service.EmailService;
import com.foly.assignment.service.SessionService;
import com.foly.assignment.service.impl.AccountServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;


@Controller
public class LoginController {
	
	@Autowired
	AccountService accountService = new AccountServiceImpl();
	
	@Autowired
	SessionService session;

	@Autowired
	LoginDao dao;

	@Autowired
	EmailService emailService;

	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/login")
	public String index(@ModelAttribute("account") Account account) {
		return "commons/login";
	}
	
	@PostMapping("/login")
	public String login(Model model, @Validated @ModelAttribute("account") Account account, BindingResult result) {
		if(!result.hasErrors()) {
			Account acc = null;
			try {
				acc = accountService.findByUser(account.getUsername()).get();
				if(acc.getPassword().equals(account.getPassword())) {
					session.set("user", acc);
					String uri = session.get("security-uri");
					if(uri!=null) {
						if(!uri.equals("") && uri.contains("/admin/")) {
							return "redirect:/home/view";
						}
						else if(uri.contains("/account/")) {
							return "redirect:/account/index";
						}
						else 
							return "commons/account";
					}
					else 
						return "commons/account";
				}
				else {
					model.addAttribute("error_loginPass", "Password không đúng!");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				model.addAttribute("error_loginUsername", "Username không tồn tại!");
			}
			
		}
		return "commons/login";
	}
	
	@PostMapping("/logout")
	public String logout(@ModelAttribute("account") Account account) {
		session.remove("user");
		session.remove("security-uri");
		return "redirect:/login";
	}

	@GetMapping("/quenmatkhau")
	public String viewquenMatKhau() {
		return "commons/viewquenmatkhau";
	}

	@GetMapping("/xacnhanotp")
	public String viewOTP(
			@RequestParam(name = "email") String email,
			Model model
	) {
		List<Account> list = dao.findAll();
		for (int i = 0; i < list.size(); i++) {
			if (email.equals(list.get(i).getEmail())) {
				Random random = new Random();
				String otp = String.valueOf(random.nextInt());
				emailService.sendEmail(email, "Mã OTP để đổi mật khẩu của bạn là : ", otp);
				HttpSession session = request.getSession();
				session.setAttribute("otp", otp);
				session.setAttribute("email", email);
				return "commons/viewOTP";
			}
		}
		model.addAttribute("me", "Gmail không tồn tại , mời bạn nhập lại.");
		model.addAttribute("ale", "danger");
		return "commons/viewquenmatkhau";
	}

	@GetMapping("/doimatkhau")
	public String anTiepTuc(@RequestParam(name = "otp") String guiOtp, Model model) {
		HttpSession session = request.getSession();
		String otp = (String) session.getAttribute("otp");
		if (otp.equals(guiOtp)) {
			return "commons/nhapmatkhau";
		}
		model.addAttribute("me", "OTP không chính xác.");
		model.addAttribute("ale", "danger");
		return "commons/viewOTP";
	}

	@GetMapping("/matkhau")
	public String doiThanhCong(Model model, @RequestParam(name = "matkhaumoi") String mk) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		dao.capNhatMK(mk, email);
		model.addAttribute("me", "Cập nhật thành công.");
		model.addAttribute("ale", "success");
		HttpSession session1 = request.getSession();
		session1.removeAttribute("email");
		session1.removeAttribute("otp");

		return "commons/nhapmatkhau";
	}

}
