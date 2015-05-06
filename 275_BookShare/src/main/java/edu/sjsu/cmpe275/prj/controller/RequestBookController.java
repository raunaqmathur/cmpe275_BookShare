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
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.requestbook;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prjservices.UserRecordService;

@SuppressWarnings("unused")
@Controller
public class RequestBookController 
{
	@Autowired
	HttpSession httpSession;
    private user userModel;
    private book bookModel;
    private category categoryModel;
    private requestbook requestBookModel,requestBookModel1;
    HttpSession session;
    List<requestbook> str;
    
    
    //ex ends
  //1.Creating the u.i for user sign up page
    
    @RequestMapping(value = "/requestbook",method = RequestMethod.GET)
    public ModelAndView uploadBook() {
    	requestBookModel = new requestbook();
    	System.out.println("m here");
		
       return new ModelAndView("requestbook", "requestbookdetails", requestBookModel);
    }
    
    @RequestMapping(value = "/requestdetails",method = RequestMethod.GET)
    public ModelAndView uploadrequestbook() {
    	JPARequestBookDAO j= new JPARequestBookDAO();
    	str=j.getRequestdetails();
    	System.out.println("steeerrr"+str);
    	ModelAndView model = new ModelAndView("requestdetails");
    	System.out.println(str);
    	   if(str.size() > 0)
           {
    		   System.out.println("in checking");
        	   model.addObject("RequestID", str.get(0).getRequestId());
        	   model.addObject("Message", str.get(0).getMessage());
        	   model.addObject("UserId", str.get(0).getUserId().getUserId());
        	   model.addObject("Time", str.get(0).getRequestBookTime().toString());
        	   System.out.println(str);
        	   
           }
    	   model.addObject("str", str);
   		return model;
       
    }
   
  /* ================================================================================*/  
    @RequestMapping(value = "/requestbook",method = RequestMethod.POST)
	public ModelAndView initN1(@ModelAttribute("requestbookdetails")requestbook requestbookModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response)
    {
        try 
        {
        	System.out.println("enter into ");
        	String msg=null;
        	JPAUserDAO objUser= new JPAUserDAO();
        	System.out.println("userid from session-"+httpSession.getAttribute("USERID"));
        	user tempuser = objUser.getUser(Integer.parseInt(httpSession.getAttribute("USERID").toString()));
        	
        	    	
        	
        	if(!tempuser.equals(null))
        		requestbookModel1.setUserId(tempuser);
        	
        	System.out.println("in book controller    " + tempuser.getUserId() );  
        	System.out.println("7" );

        	
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "message", "message", "Message can't be empty");
            System.out.println("2" );
            
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
            	
            	
            	
            	
            	System.out.println("3" );
            	List<ObjectError> t = bindingResult.getAllErrors();
            	
            	
            	for(ObjectError e : t)
            	{
            		System.out.println(e.getDefaultMessage() );
            		
            	}
            	
            	ModelAndView mv = new ModelAndView("requestbook");
            	mv.addObject("requestbookdetails", requestbookModel1);
            	mv.addObject("msg", "request creation error!");
            	return mv;
              //  return new ModelAndView("requestbook", "requestbookdetails", requestbookModel1);
            }
            else
            {
            	
            	System.out.println("4" );
            	requestbookModel1.setActive(1);
            	
            	
            	
            	
            	try
            	{
            		
            	}
            	catch(Exception ex)
            	{
            		ex.printStackTrace();
            		
            	}
            	System.out.println("6" );
            	//Integer.parseInt(session.getAttribute("userId").toString())
            	
            	
              	 
            	
            	
            	JPARequestBookDAO obj= new JPARequestBookDAO();
            	long l =obj.insert(requestbookModel1);
            	System.out.println(l);
            	
            	msg="Your Request is made successfully";
            	System.out.println(msg);
            	ModelAndView model = new ModelAndView("requestbook");
            	requestBookModel = new requestbook();
            	model.addObject("requestbookdetails", requestBookModel);
           	 	model.addObject("msg", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in Requestbook Controller "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("requestbook", "requestbookdetails", requestbookModel1);
        }
        
    }

}
