package edu.bit.ex;

import java.security.Principal;
import java.util.Locale;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.vo.MemberUser;
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
	
	
	@GetMapping("/loginInfo")
	public String loginInfo(Principal principal) {
	    log.info("loginInfo()..");
	    
	    //1.Controller를 통하여 Principal 객체로 가져오는 방법
	    String userId = principal.getName();
	    System.out.println("유저 아이디 : " + principal.getName());
	    
	    //2.SpringContextHolder를 통하여 가져오는 방법(일시적인 Bean에서 사용할 수 있음)
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    userId = auth.getName();
	    System.out.println("유저 아이디 : " + userId);
	    
	    //3.UserDetails 갖고 오기
	    UserDetails userDetails = (UserDetails)auth.getPrincipal();
	    System.out.println("유저 아이디 : " + userDetails.getUsername());
	    
	    //4.MemberUser 꺼내오기
	    MemberUser memberUser = (MemberUser)auth.getPrincipal();
	    System.out.println(memberUser.getUsername());
	    
	    memberUser = (MemberUser)userDetails;
	    System.out.println(memberUser.getUsername());
	    
	    //5.User 클래스로 변환하여 가져오는 방법
	    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    userId = user.getUsername();
	    System.out.println("유저 아이디 : " + userId);

	    return "home";
	}
}
