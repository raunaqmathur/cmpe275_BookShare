package edu.sjsu.cmpe275.prj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import edu.sjsu.cmpe275.prj.dao.*;
import edu.sjsu.cmpe275.prj.models.Login;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prj.utils.CheckSession;
import edu.sjsu.cmpe275.prj.utils.PlayPP;
import edu.sjsu.cmpe275.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class LoginController {
    
	Login loginModel;
    
    @Autowired
	private HttpSession httpSession;
    
	@Autowired
	private CheckSession sessionService;
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage() {
    	if(null != httpSession.getAttribute("USERID")) {
    		httpSession.removeAttribute("USERID");
        	httpSession.removeAttribute("USERNAME");
        	httpSession.invalidate();
    	}
    	loginModel = new Login();
    	return new ModelAndView("login", "logindetails", loginModel);
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView recieveCategory(@ModelAttribute("logindetails")Login loginModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
        try {
        	
        	String msg=null;
        	
           if(loginModel1.getUserEmail().equals(null) || loginModel1.getUserEmail().isEmpty())
           {
        	ModelAndView model = new ModelAndView();
        	loginModel = new Login();
           	model.addObject("msg", "Invalid user email and password combination");
           	model.addObject("logindetails", loginModel);
          	model.setViewName("login"); 
           }
           
        	else {
            	JPALoginDAO obj= new JPALoginDAO();
            	loginModel1.setPassword(PlayPP.sha1(loginModel1.getPassword()));
            	int l =obj.validate(loginModel1);
            	
            	ModelAndView model = new ModelAndView();
            	if(l == 0) {
	            	loginModel = new Login();
	            	model.addObject("msg", "Invalid user email and password combination");
	            	model.addObject("logindetails", loginModel);
	           	 	model.setViewName("login");
            	} else {
            		JPAUserDAO jp = new JPAUserDAO();
            		
            		loginModel1.setUserId(l);
            		httpSession.setAttribute("USERID", loginModel1.getUserId());
            		user tempUser = jp.getUser(loginModel1.getUserId());
            		httpSession.setAttribute("USERNAME", tempUser.getName());
            		sessionService.setHttpSession(httpSession);
            		System.out.println("my userid in session is" + httpSession.getAttribute("USERID"));
            		return new ModelAndView("redirect:/");
            	}
           	 	return model;
            }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("error404");
        }
		return null;
    }
    
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logoutPage(HttpServletRequest request,  HttpServletResponse response) {
    	httpSession = sessionService.getHttpSession();
    	httpSession.removeAttribute("USERID");
    	httpSession.removeAttribute("USERNAME");
    	httpSession.invalidate();
    	sessionService.setHttpSession(null);
    	System.out.println("in logot");
    	loginModel = new Login();
    	response.setHeader("Cache-Control","no-cache");
    	response.setHeader("Cache-Control","no-store");
    	response.setDateHeader("Expires", 0);
        return new ModelAndView("login", "logindetails", loginModel);
    }
    
}