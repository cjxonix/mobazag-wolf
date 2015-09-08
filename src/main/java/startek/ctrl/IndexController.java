/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startek.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Niwoogaba_Joel
 */
@Controller
public class IndexController {

	
	
	@RequestMapping("/")
    public String starter() {
        return "index";
        //return "/WEB-INF/jsp/index.jsp";
    }
	
    @RequestMapping("/index")
    public String index() {
        return "index";
        //return "/WEB-INF/jsp/index.jsp";
    }
  
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/forgot_password")
    public String forgotPassword() {
        return "forgot_password";
    }
   
    
}
