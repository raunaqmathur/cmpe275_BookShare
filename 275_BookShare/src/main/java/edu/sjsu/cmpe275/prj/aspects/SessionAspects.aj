package edu.sjsu.cmpe275.prj.aspects;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.datastax.driver.core.exceptions.UnauthorizedException;

import edu.sjsu.cmpe275.prj.models.Login;



public aspect SessionAspects {
	
	 @Autowired
		private HttpSession httpSession;
		
		public HttpSession getHttpSession() {
			return httpSession;
		}

		public void setHttpSession(HttpSession httpSession) {
			this.httpSession = httpSession;
		}
	
	pointcut shareAccessControl() :
		execution(public ModelAndView edu.sjsu.cmpe275.prj.controller.BookController.uploadBook());
	
	ModelAndView around () : (shareAccessControl()) {
		
		try
    	{

		    	if(!httpSession.getAttribute("USERID").toString().equals("") && httpSession.getAttribute("USERID") != null)
		    	{	System.out.println("user Aspect logged in as: " + httpSession.getAttribute("USERID"));
					proceed();
		    	}
		    	else
		    	{
					System.out.println("user not logged Aspect in");
	    		
	    			Login login = new Login();
	        	
	    		
	    	       return new ModelAndView("login", "logindetails", login);
		    	}
		} catch (Exception e) {
				System.out.println("user not logged Aspect in");
    		
    			Login login = new Login();
        	
    		
    	       return new ModelAndView("login", "logindetails", login);
		}
		return null;
		
	}
	
	pointcut shareAccessControl1(int a) :
		execution(public ModelAndView edu.sjsu.cmpe275.prj.controller.BookController.updateBook(int a));
	
	ModelAndView around () : (shareAccessControl1()) {
		
		try
    	{

		    	if(!httpSession.getAttribute("USERID").toString().equals("") && httpSession.getAttribute("USERID") != null)
		    	{	System.out.println("user Aspect logged in as: " + httpSession.getAttribute("USERID"));
					proceed();
		    	}
		    	else
		    	{
					System.out.println("user not logged Aspect in");
	    		
	    			Login login = new Login();
	        	
	    		
	    	       return new ModelAndView("login", "logindetails", login);
		    	}
		} catch (Exception e) {
				System.out.println("user not logged Aspect in");
    		
    			Login login = new Login();
        	
    		
    	       return new ModelAndView("login", "logindetails", login);
		}
		return null;
		
	}
}