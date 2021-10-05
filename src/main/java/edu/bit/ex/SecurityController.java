package edu.bit.ex;

import java.text.DateFormat; 
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;


@Log4j
@RequestMapping("/security/*")
@Controller
public class SecurityController {
	
    @GetMapping("/all")
    public void doAll() {
        log.info("do all can access everybody");
    }
    
    
    @GetMapping("/member")
    public void doMember() {
        log.info("login member");
    }
    
    @GetMapping("/admin")
    public void doAdmin() {
        log.info("login admin");
    }

}
