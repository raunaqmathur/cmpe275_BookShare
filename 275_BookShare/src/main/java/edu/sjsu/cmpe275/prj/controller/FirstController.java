package edu.sjsu.cmpe275.prj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 



<<<<<<< HEAD











import edu.sjsu.cmpe275.prj.dao.*;
import edu.sjsu.cmpe275.prj.models.LandingPage;
=======
import edu.sjsu.cmpe275.prj.dao.*;
import edu.sjsu.cmpe275.prj.models.Login;
>>>>>>> parent of cbd5675... Revert "Merge remote-tracking branch 'origin/master'"
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.statistics;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prj.utils.PlayPP;
import edu.sjsu.cmpe275.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class FirstController {

    @Autowired 
    private UserRecordService userRecordService;
    private HomePageModel homepageModel;
    private user userModel;
    private book bookModel;
    private category categoryModel;
    private LandingPage landingPage;
    HttpSession session;
    private static Jedis jedis;
    
    //1.Creating the u.i for user sign up page
    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public ModelAndView initN() {
    	userModel = new user();
<<<<<<< HEAD
        return new ModelAndView("userhome", "userdetails", userModel);
=======
    	
		
       return new ModelAndView("signup", "userdetails", userModel);
>>>>>>> parent of cbd5675... Revert "Merge remote-tracking branch 'origin/master'"
    }
    
    @RequestMapping(value = "/showuser/{userId}",method = RequestMethod.GET)
    public ModelAndView showBook(@PathVariable int userId, HttpServletRequest request) {

    	ModelAndView mv = new ModelAndView();
    	userModel = new user();
    	
    	JPAUserDAO obj= new JPAUserDAO();
    	userModel = obj.getUser(userId);
	
        mv.addObject("userdetails", userModel);
        mv.setViewName("showuser");
        
        return mv;
    }
    
    
   
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ModelAndView initN1(@ModelAttribute("userdetails")user userModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
        try 
        {
        	String msg=null;
           
            //ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"id","id", "id can not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"name","name", "name not be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "emailId", "emailId", "emailId cant be empty");
            //ValidationUtils.r
 
            JPAUserDAO tempEmail = new JPAUserDAO();
            
            String one = userModel1.getEmailId();
         	String two = ".edu";
            if(!(one.endsWith(two)))
            {
            	
            	
            	 
            	 
            	 ModelAndView mv = new ModelAndView();
            	
            	 mv.addObject("msg", "edu. email required");
                 mv.setViewName("signup");
            	
            	 return mv;
            	
            	 
            	 
            }	 
            if(tempEmail.getExistingEmail(userModel1.getEmailId()) > 0)
            {
            	 ModelAndView mv1 = new ModelAndView();
            	 mv1.addObject("msg", "user with this email already exists");
                 mv1.setViewName("signup");
            	
            	 return mv1;
            	 
            }	
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
                return new ModelAndView("signup", "userdetails", userModel1);
            }
            else
            {
            	System.out.println("user model details here --" +userModel1.getName()+userModel1.getPhone());
            	// insert the record by calling the service
            	//userRecordService.insertUser(userModel1);
            	
            	userModel1.setActive(1);
            	System.out.println(PlayPP.sha1(userModel1.getPassword()));
            	userModel1.setPassword(PlayPP.sha1(userModel1.getPassword()));
            	JPAUserDAO obj= new JPAUserDAO();
            	int l =obj.insert(userModel1);
            	userModel1.setUserId(l);
            	JPAUserStatisticsDAO objUserStat = new JPAUserStatisticsDAO();
            	statistics userStatistics = new statistics();
            	userStatistics.setNoOfBookDeleted(0);
            	userStatistics.setNoOfBookPurchased(0);
            	userStatistics.setNoOfBookTransac(0);
            	userStatistics.setNoOfBookUploaded(0);
            	userStatistics.setRatingBuyer(0);
            	userStatistics.setRatingSeller(0);
            	userStatistics.setUser(userModel1);
            	objUserStat.insert(userStatistics);
            	System.out.println(l);
<<<<<<< HEAD
            	ModelAndView model = new ModelAndView("showuser");
            	model.addObject("redirectTo", "./userhome");
            	model.addObject("userdetails", userModel1);
=======
            	
            	Login loginModel = new Login();
            	ModelAndView model = new ModelAndView("login");
            	
            	model.addObject("logindetails", loginModel);
>>>>>>> parent of cbd5675... Revert "Merge remote-tracking branch 'origin/master'"
           	 	
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("signup", "userdetails", userModel1);
        }
        
    }
    
    
    
    /*
     * This method loads the homepage on application startup.
     * Works on "/" mapping.     * */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView initM() {
<<<<<<< HEAD
		System.out.println("Landing Page");
		ModelAndView mv = new ModelAndView();
		// getting data
		landingPage = new LandingPage();
		JPALandingPageDAO obj = new JPALandingPageDAO();
		landingPage.setBooks(obj.getBooks());
		landingPage.setCategories(obj.getCategories());
		System.out.println(landingPage);
		mv.addObject("pagedetails", landingPage);
		mv.setViewName("home");
		return mv;
    }
    
 //karan code starts
=======
    	
    	
    	
    	 return new ModelAndView("home", "userdetails", null);
    }
 
>>>>>>> parent of cbd5675... Revert "Merge remote-tracking branch 'origin/master'"
	 //method to testCassandra
    @RequestMapping(value = "/Cassandra",method = RequestMethod.GET)
    public ModelAndView initN09() {
    	
    	CassandraConnectionDAO.testCassandra();
		
		
		
    	return initN();
    }
    
    //method to testredis
    @RequestMapping(value = "/Redis",method = RequestMethod.GET)
    public ModelAndView initN10() {
    	
    	/*CassandraConnectionDAO.testCassandra();
    	userModel = new user();
    	jedis=new Jedis("localhost");
		jedis.connect();
		System.out.println("Successfully connected to the redis server");
		String [] Kar={"karan khanna","sjsu","se"};
		System.out.println(Kar);
		jedis.set("karan", "khanna");
		System.out.println("saving in redis");
		System.out.println("getting from redis---" + jedis.get("karan"));*/
		
		
		
       return initN();
    }
	//karan code ends

}