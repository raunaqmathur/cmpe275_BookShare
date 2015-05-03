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



import edu.sjsu.cmpe275.prj.models.Book;
import edu.sjsu.cmpe275.prj.models.Category;
import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class FirstController {
 
    
    
    @Autowired 
    private UserRecordService userRecordService;
 
    
    private HomePageModel homepageModel;
    
    private user userModel;
    
    private Book bookModel;
    private Category categoryModel;
    HttpSession session;
    /**
     * This method will load the homepage.jsp page when the /homepage requested.
     */
    @RequestMapping(value = "/homepage",method = RequestMethod.GET)
    public ModelAndView init() {
    	homepageModel = new HomePageModel();
    	
    	
    	
		
       return new ModelAndView("homepage", "homepageDetails", homepageModel);
    }
 
    /**
     * This method will be called when the user submits the homepage details from homepage.jsp page.
     * If there is any error it will be displayed on the same page, if the user is valid then, will 
     * be redirected to success page.
     * 
     * @param homepageModel
     * @param bindingResult
     * @param request
     * @param response
     * @return ModelAndView
     */ 
    @RequestMapping(value = "/homepage",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("homepageDetails")HomePageModel homepageModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
        try 
        {
        	String msg=null;
           
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"id","id", "id can not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"firstname","firstname", "firstname not be empty");
 
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
                return new ModelAndView("homepage", "homepageDetails", homepageModel1);
            }
            else
            {
            	
            	// insert the record by calling the service
            	userRecordService.insertUser(homepageModel1);
            	msg="Your Page created successfully";
            	ModelAndView model = new ModelAndView("userpage");
            	model.addObject("userpageDetails", homepageModel1);
           	 	model.addObject("Message", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("homepage", "homepageDetails", homepageModel1);
        }
        
    }
    
    
    /**
     * This method will load the userpage.jsp page when the "/homepage/userId" page requested.
     * It also returns json in case brief=true
     */
    @RequestMapping(value = "/homepage/{userId}",method = RequestMethod.GET)
    public ModelAndView init(@PathVariable("userId") String id,@RequestParam(value = "brief", required = false, defaultValue = "false") String jsoncheck){
    	
		homepageModel = new HomePageModel();
	       
	       homepageModel.setId(id);
	       //homepageModel=userRecordService.getUser(homepageModel);
	       
	       // if user doesn't exist, then redirect to error page
	       if(homepageModel.getFirstname()==null || homepageModel.getFirstname().isEmpty())
	       {
	    	   
	    	   return new ModelAndView("error404", "userpageDetails", homepageModel);
	       }
	       
	       // if json requested then redirected to corresponding method.
		if(jsoncheck.equalsIgnoreCase("true"))
		{
			 return useJson(homepageModel);
			
			
		}
		// else return normal content through ModelAndView
		else
		{	String msg=null;
			
		       
		       ModelAndView model = new ModelAndView("userpage");
	           	 model.addObject("userpageDetails", homepageModel);
	           	 model.addObject("Message", msg);
	           	 return model;
		      
        }
    }
    
    /*
     * Internal method to convert java object to json object using object mapper.
     * */
    	public ModelAndView  useJson(HomePageModel homepageModel) {
    		
            System.out.println("in  json conversion method" + homepageModel.getFirstname());
            ObjectMapper obk = new ObjectMapper();
            String message = null;
      			
			//sending JSon data withing Html pre tag
			try {
				message = "<pre>"
						+ obk.writer().withDefaultPrettyPrinter().writeValueAsString(homepageModel)
						+"<pre>";
				
				
				System.out.println(message);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			ModelAndView model = new ModelAndView("jsonP");
			model.addObject("jsonDetails", message);

            return model;
        
    }
    

    	/**
         * This method corresponds to /homepage/userid and updates the info. passed through html form using POST.
         */ 
    @RequestMapping(value = "/homepage/{userId}",method = RequestMethod.POST,params="update")
    public ModelAndView init12(@ModelAttribute("homepageDetails")HomePageModel homepageModel, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response,@PathVariable("userId") String id, 
            @RequestParam(value = "firstname", required = false, defaultValue = "false") String firstname,
            @RequestParam(value = "lastname", required = false, defaultValue = "false") String lastname,
            @RequestParam(value = "email", required = false, defaultValue = "false") String email,
            @RequestParam(value = "address", required = false, defaultValue = "false") String address,
            @RequestParam(value = "organization", required = false, defaultValue = "false") String ogranization,
            @RequestParam(value = "aboutMyself", required = false, defaultValue = "false") String aboutMyself){
    	
    	
		
         ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"firstname","firstname", "firstname not be empty");
         
         if (bindingResult.hasErrors())
         {
             //returning the errors on same page if any errors..
             return new ModelAndView("userpage", "userpageDetails", homepageModel);
         }
         else
         {
        	 
        	 homepageModel.setId(id);
        	 String msg=null;
        	/* if(userRecordService.updateUser(homepageModel)==1) // calling service to update the record.
        	 {
        	 msg="successfully updated!";
        	 }
        	 else
        	 {
        		msg="not updated!";
        	 }*/
        	 ModelAndView model = new ModelAndView("userpage");
        	 model.addObject("userpageDetails", homepageModel);
        	 model.addObject("Message", msg);
        	 return model;
        	
        	 
        	 
        	 
         }
		
      
    }
    
    /**
     * This method corresponds to /homepage/userid and updates the info. passed through query parameters using POST.
     */ 
    @RequestMapping(value = "/homepage/{userId}",method = RequestMethod.POST)
    public ModelAndView init15(  
            HttpServletRequest request,  HttpServletResponse response,
            @PathVariable("userId") String id, 
            @RequestParam(value = "firstname", required = false, defaultValue = "testFname") String fname,
            @RequestParam(value = "lastname", required = false, defaultValue = "false") String lastname,
            @RequestParam(value = "email", required = false, defaultValue = "false") String email,
            @RequestParam(value = "address", required = false, defaultValue = "false") String address,
            @RequestParam(value = "organization", required = false, defaultValue = "false") String ogranization,
            @RequestParam(value = "aboutMyself", required = false, defaultValue = "false") String aboutMyself){
    	
    	
    	
		 HomePageModel homepageModel11 = new HomePageModel();
		 String msg=null;
		 homepageModel11.setId(id);
        	 String returned_firstname="test";
        			 //userRecordService.getUser(homepageModel11).getFirstname(); // checking if record exists in db.
        	 System.out.println("returnd name is"  + returned_firstname);
        	 
        	 // if record doesn't exist then create one using service.
        	 if(returned_firstname==null || returned_firstname.isEmpty())
        	 {
        		 	homepageModel11.setId(id);
        			homepageModel11.setFirstname(fname);
        			homepageModel11.setFirstname(fname);
        			homepageModel11.setLastname(lastname);
        			homepageModel11.setEmail(email);
        			homepageModel11.setAddress(address);
        			homepageModel11.setOrganization(ogranization);
        			homepageModel11.setAboutMyself(aboutMyself);
        		    msg="successfully created";
        		 //  userRecordService.insertUser(homepageModel11);
        		 
        	 }
        	 
        	 // updating the record in db based on values passed through query parameters.
        	 
        	 else
        	 {
        		 	homepageModel11.setId(id);
        			homepageModel11.setFirstname(fname);
        			homepageModel11.setFirstname(fname);
        			homepageModel11.setLastname(lastname);
        			homepageModel11.setEmail(email);
        			homepageModel11.setAddress(address);
        			homepageModel11.setOrganization(ogranization);
        			homepageModel11.setAboutMyself(aboutMyself);
        		 /*if(userRecordService.updateUser(homepageModel11)==1)
        		 {
        			 msg="successfully updated!";
        		 }
        		 else
        		 {
        			 msg="not updated!";
        		 }*/
        	 }
        	 ModelAndView model = new ModelAndView("userpage");
        	 model.addObject("userpageDetails", homepageModel11);
        	 model.addObject("Message", msg);
        	 return model;
        	 
    }
    
    /*
     * This method deletes the record using DELETE on request from form.
     * */
    @RequestMapping(value = "/homepage/{userId}",method = RequestMethod.POST,params="delete")
    public String init123(@ModelAttribute("homepageDetails")HomePageModel homepageModel, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response,@PathVariable("userId") String id){
    
        	 return initD(id); // calling the delete method.
        
		
         
        
    }
    
    
    /*
     * This method deletes the record using DELETE.
     * It can work from clients such as POSTMAN client.
     * */    
    @RequestMapping(value = "/homepage/{userId}",method = RequestMethod.DELETE)
    public String initD(@PathVariable("userId") String id){
    	
   
       homepageModel = new HomePageModel();
       
       homepageModel.setId(id);
       /*if(userRecordService.deleteUser(homepageModel))
       {
    	  
    	  return "redirect:/homepage";
    	  
    	   
    	   
       }*/

       return null;
    }
    //exp starts
    
    //1.Creating the u.i for user sign up page
    @RequestMapping(value = "/userhome",method = RequestMethod.GET)
    public ModelAndView initN() {
    	userModel = new user();
    	
		
       return new ModelAndView("userhome", "userdetails", userModel);
    }
    
   
    
    
    
    
    //ex ends
  //1.Creating the u.i for user sign up page
    @RequestMapping(value = "/bookhome",method = RequestMethod.GET)
    public ModelAndView uploadBook() {
    	bookModel = new Book();
    	
		
       return new ModelAndView("bookhome", "bookdetails", bookModel);
    }
    
    
    @RequestMapping(value = "/bookhome",method = RequestMethod.POST)
    public ModelAndView initN1(@ModelAttribute("bookdetails")Book bookModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response,
             @RequestParam(value="categoryX") int  categoryId) 
    {
        try 
        {
        	String msg=null;
           
        	System.out.println("in book controller" + categoryId );
        	JPAUserDAO objUser= new JPAUserDAO();
        	user tempuser = objUser.getUser(11);
        	if(!tempuser.equals(null))
        		bookModel1.setUserId(tempuser);
        	
        	System.out.println("in book controller    " + tempuser.getUserId() );  
        	System.out.println("7" );
        	
        	JPACategoryDAO objCat= new JPACategoryDAO();
        	Category tempCat = objCat.getCategory( categoryId);
        	if(!tempCat.equals(null))
        		bookModel1.setCategoryId(tempCat);
        	
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "title", "title", "Title can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"author","author", "Author can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "isbn", "isbn", "ISBN can't be empty");
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"condition","condition", "Condition can't be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "pickupAddress", "pickupAddress", "Pickup Address can't be empty");
            
            System.out.println("2" );
            
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
            	
            	/*if (!file.isEmpty()) {
                    try {
                        byte[] bytes = file.getBytes();
                        BufferedOutputStream stream =
                                new BufferedOutputStream(new FileOutputStream(new File(file.getName())));
                        stream.write(bytes);
                        stream.close();
                        System.out.println("Successfully uploaded " + file.getName() + ".");
                    } catch (Exception e) {
                    	System.out.println("Failed to upload " + file.getName() + " because some exception occured.");
                    }
                } else {
                	System.out.println("Failed to upload " + file.getName() + " because the file was empty.");
                }*/
            	
            	
            	System.out.println("3" );
            	List<ObjectError> t = bindingResult.getAllErrors();
            	
            	
            	for(ObjectError e : t)
            	{
            		System.out.println(e.getDefaultMessage() );
            		
            	}
            	
            	
            	
            	
            	
            	
            	
            	
                return new ModelAndView("bookhome", "bookdetails", bookModel1);
            }
            else
            {
            	
            	System.out.println("4" );
            	bookModel1.setActive(1);
            	bookModel1.setStatus("New");
            	
            	try
            	{
            		//session.setAttribute("userId", 11);
            	//System.out.println("returnd user id is"  + session.getAttribute("userId").toString());
            	}
            	catch(Exception ex)
            	{
            		ex.printStackTrace();
            		
            	}
            	System.out.println("6" );
            	//Integer.parseInt(session.getAttribute("userId").toString())
            	
            	System.out.println("returnd cat id is"  + tempCat.getCategoryId());
              	 
            	
            	
            	JPABookDAO obj= new JPABookDAO();
            	long l =obj.insert(bookModel1);
            	System.out.println(l);
            	
            	msg="Your Book is uploaded successfully";
            	ModelAndView model = new ModelAndView("bookhome");
            	bookModel = new Book();
            	model.addObject("bookDetails", bookModel);
           	 	model.addObject("Message", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("bookhome", "bookdetails", bookModel1);
        }
        
    }
    
    
    @RequestMapping(value = "/userhome",method = RequestMethod.POST)
    public ModelAndView initN1(@ModelAttribute("userdetails")user userModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
        try 
        {
        	String msg=null;
           
            //ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"id","id", "id can not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"name","name", "name not be empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "emailId", "emailId", "emailId cant be empty");
 
            JPAUserDAO tempEmail = new JPAUserDAO();
            
            if(tempEmail.getExistingEmail(userModel1.getEmailId()) > 0)
            {
            	
            	 ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "emailId", "emailId", "emailId already exists");
            	 System.out.println("ININININ");
            }	
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
                return new ModelAndView("userhome", "userdetails", userModel1);
            }
            else
            {
            	System.out.println("user model details here --" +userModel1.getName()+userModel1.getPhone());
            	// insert the record by calling the service
            	//userRecordService.insertUser(userModel1);
            	
            	userModel1.setActive(1);
            	
            	JPAUserDAO obj= new JPAUserDAO();
            	long l =obj.insert(userModel1);
            	System.out.println(l);
            	
            	msg="Your Page created successfully";
            	ModelAndView model = new ModelAndView("userhome");
            	model.addObject("userpageDetails", userModel1);
           	 	model.addObject("Message", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("userhome", "userdetails", userModel1);
        }
        
    }
    
    
    @RequestMapping(value = "/category",method = RequestMethod.GET)
    public ModelAndView uploadCategory() {
    	categoryModel = new Category();
    	
		
       return new ModelAndView("category", "categorydetails", categoryModel);
    }
    
    
    @RequestMapping(value = "/category",method = RequestMethod.POST)
    public ModelAndView recieveCategory(@ModelAttribute("categorydetails")Category categoryModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response) 
    {
        try 
        {
        	String msg=null;
           
            
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"name","name", "Name can't be empty");
            
            
            
            if (bindingResult.hasErrors())
            {
                //returning the errors on same page if any errors..
                return new ModelAndView("category", "categorydetails", categoryModel1);
            }
            else
            {
            	
            	
            	categoryModel1.setActive(1);
            	
            	JPACategoryDAO obj= new JPACategoryDAO();
            	long l =obj.insert(categoryModel1);
            	System.out.println(l);
            	
            	msg="Your Category is entered successfully";
            	ModelAndView model = new ModelAndView("category");
            	categoryModel = new Category();
            	
            	model.addObject("categoryDetails", categoryModel);
           	 	model.addObject("Message", msg);
           	 	return model;
          }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("category", "categorydetails", categoryModel1);
        }
        
    }
    
    
    //ex ends


    
    /*
     * This method loads the homepage on application startup.
     * Works on "/" mapping.     * */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView initM() {
    	
    	System.out.println("entrii");
    	
    	return init();
    }

}