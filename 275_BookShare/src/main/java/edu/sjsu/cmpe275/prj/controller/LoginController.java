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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
 














import edu.sjsu.cmpe275.prj.dao.*;
import edu.sjsu.cmpe275.prj.models.Login;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prj.utils.PlayPP;
import edu.sjsu.cmpe275.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class LoginController {
 
    
    
   
    
   
    Login loginModel;
    
    @Autowired
	private HttpSession httpSession;
    
    
    
    
    //ex ends
  //1.Creating the u.i for user sign up page
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage() {
    	loginModel = new Login();
    	
		
       return new ModelAndView("login", "logindetails", loginModel);
    }
    
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView recieveCategory(@ModelAttribute("logindetails")Login loginModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
        try 
        {
        	String msg=null;
           
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"userId","userId", "User Id can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"password","password", "Password Id can't be empty");
            
            
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
                return new ModelAndView("login", "logindetails", loginModel1);
            }
            else
            {
            	
            	
            	
            	
            	JPALoginDAO obj= new JPALoginDAO();
            	
            	loginModel1.setPassword(PlayPP.sha1(loginModel1.getPassword()));
            	
            	
            	int l =obj.validate(loginModel1);
            	
            	
            	System.out.println(l);
            	ModelAndView model = new ModelAndView();
            	if(l == 0)
            	{
	            	
	            	
	            	loginModel = new Login();
	            	model.addObject("msg", "Invalid user id and password combination");
	            	model.addObject("loginDetails", loginModel);
	           	 	model.setViewName("login");
            	}
            	else
            	{
            		
            		
            		httpSession.setAttribute("USERID", loginModel1.getUserId());
	           	 	model.setViewName("home");
            	}
            	
            	
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            
            ModelAndView model = new ModelAndView();
            loginModel = new Login();
        	model.addObject("msg", "Connection Error");
        	model.addObject("loginDetails", loginModel);
       	 	model.setViewName("login");
       	 	return model;
        }
        
    }
    
   

    
   

}