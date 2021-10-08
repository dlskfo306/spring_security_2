package edu.bit.ex;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}." + locale);
		return "home";
	}
	
	
	@GetMapping("login/loginForm")
	public String loginForm() {
	    log.info("Welcome Login Form");
	    return "login/loginForm2";
	}
	
	//DB custom
	@GetMapping("/user/userHome")
	public void userHome() {
	    log.info("userHome()..");
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {
	    log.info("adminHome()..");
	}
	
	@GetMapping("/login/accessDenied")
	public void accessDenied() {
	    log.info("accessDenied()..");
	}
}
