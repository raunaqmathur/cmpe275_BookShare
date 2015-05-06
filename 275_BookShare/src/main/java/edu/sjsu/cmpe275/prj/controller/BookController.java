package edu.sjsu.cmpe275.prj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
 




















import edu.sjsu.cmpe275.prj.dao.*;
import edu.sjsu.cmpe275.prj.models.Login;
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.BookImageUpload;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.statistics;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class BookController {

 
    
    
   
    
   
	private String imagePath = "WEB-INF\\images";
    private user userModel;
    
    private book bookModel;
    private category categoryModel;
    private Login login;
    @Autowired
	private HttpSession httpSession;
	
	public HttpSession getHttpSession() {
		return httpSession;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}


    
    @RequestMapping(value = "/showbook/{bookId}",method = RequestMethod.GET)
    public ModelAndView showBook(@PathVariable int bookId, HttpServletRequest request) {
    	
    	ModelAndView mv = new ModelAndView();
    	bookModel = new book();
    	//bookModel = new book();
    	JPABookDAO obj= new JPABookDAO();
    	bookModel = obj.getBook(bookId);
		//System.out.println("going: " +bookModel.getBookId() );
    	
    	System.out.println("timestamp = " + bookModel.getBookTime());
    	
    	
        mv.addObject("catId", bookModel.getCategoryId().getName());
        mv.addObject("bookdetails", bookModel);
        mv.setViewName("showbook");
        
       return mv;
    }
    
    
   
    @RequestMapping(value = "/bookhome",method = RequestMethod.GET)
    public ModelAndView uploadBook( HttpServletRequest request,  HttpServletResponse response, HttpSession session) {
    	//session = request.getSession();
    	
    	
    	
    	ModelAndView mv = new ModelAndView();
    	
    	try
    	{

		    	if(!httpSession.getAttribute("USERID").toString().equals(""))
		    	{
			    	bookModel = new book();
			    	
			    	System.out.println("user logged in as: " + httpSession.getAttribute("USERID"));
			    	//mv.addObject("path", "bookhome");
			    	mv.addObject("path", "./bookhome");
			        mv.addObject("categ", "1");
			        mv.addObject("bookdetails", bookModel);
			        mv.addObject("buttonX", "Create");
			        mv.setViewName("bookhome");
		    	}
		    	else
		    	{
		    		
		    		System.out.println("user not logged in");
		    		
		    		login = new Login();
		        	
		    		
		    	       return new ModelAndView("login", "logindetails", login);
		    		
		    		
		    	}
    	}
    	catch(Exception ex)
    	{
    		
    		System.out.println("user not logged in");
    		
    		login = new Login();
        	
    		
    	       return new ModelAndView("login", "logindetails", login);
    		
    		
    	}
       return mv;

    }
    
    
    @RequestMapping(value = "/bookhome/{bookId}",method = RequestMethod.GET)
    public ModelAndView updateBook(@PathVariable int bookId) {
    	ModelAndView mv = new ModelAndView();
    	bookModel = new book();
    	JPABookDAO obj= new JPABookDAO();
    	bookModel = obj.getBook(bookId);


		System.out.println("going: " +bookModel.getBookId() );
		mv.addObject("path", "../bookhome");
        mv.addObject("categ", bookModel.getCategoryId().getCategoryId());
        mv.addObject("bookdetails", bookModel);
        mv.addObject("buttonX", "Update");
        mv.setViewName("bookhome");
        
       return mv;
    }
    
    @RequestMapping(value = "/bookhome",method = RequestMethod.POST)
    public ModelAndView initN1(@ModelAttribute("bookdetails")book bookModel1, BindingResult bindingResult, 
            HttpServletRequest request,  HttpServletResponse response,
             @RequestParam(value="categoryX") int  categoryId) 
    {


    	if(bookModel1.getBookId() == 0)
    	{
		        try 
		        {
		        	String msg=null;

		           
		        	System.out.println("in book controller" + bookModel1.getBookId() );
		        	JPAUserDAO objUser= new JPAUserDAO();
		        	user tempuser = objUser.getUser(15);//session
		        	if(!tempuser.equals(null))
		        		bookModel1.setUserId(tempuser);

		        	
		        	System.out.println("in book controller    " + tempuser.getUserId() );  
		        	System.out.println("7" );

		        	
		        	JPACategoryDAO objCat= new JPACategoryDAO();
		        	category tempCat = objCat.getCategory( categoryId);
		        	if(!tempCat.equals(null))
		        		bookModel1.setCategoryId(tempCat);


		        	
		            
		        	ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "title", "title", "Title can't be empty");
		            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"author","author", "Author can't be empty");
		            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "isbn", "isbn", "ISBN can't be empty");

		            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"description","description", "Description can't be empty");
		            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"condition","condition", "Condition can't be empty");
		            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "pickupAddress", "pickupAddress", "Pickup Address can't be empty");

		            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "price", "price", "Price can't be empty");
		            
		           // if(categoryId == 0)
		            //	ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "category", "category", "category can't be empty");
		            
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
		            	bookModel1.setBookTime((new Date()));
		            	
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
		            	
		            	
		            	//user statistics change -- uploaded, seller
						JPAUserStatisticsDAO objUserStat = new JPAUserStatisticsDAO();
		            	statistics userStatistics = new statistics();
		            	userStatistics = objUserStat.getUserStatisticsByUser(15); //session
		            	int noOfBookUploaded = userStatistics.getNoOfBookUploaded();
		            	userStatistics.setNoOfBookUploaded(noOfBookUploaded + 1);
		            	objUserStat = new JPAUserStatisticsDAO();
		            	
		            	objUserStat.update(userStatistics);
		            	
		            	
		            	
		            	
		            	msg="Your book is uploaded successfully";
		            	ModelAndView mv = new ModelAndView();
		            	mv.addObject("redirectTo", "./bookhome");
		            	mv.addObject("redirectToBuy", "./purchase");
		            	mv.addObject("catId", bookModel1.getCategoryId().getName());
		                mv.addObject("bookdetails", bookModel1);
		                mv.setViewName("showbook");
		           	 	return mv;
		          }
		        } catch (Exception e) {
		            System.out.println("Exception in FirstController "+e.getMessage());
		            e.printStackTrace();
		            return new ModelAndView("bookhome", "bookdetails", bookModel1);
		        }
    	}
    	else
    	{
    		try 
            {
































            	String msg=null;
               
            	System.out.println("in book update controller  " + bookModel1.getBookId() );
            	JPAUserDAO objUser= new JPAUserDAO();
            	user tempuser = objUser.getUser(15);//session
            	if(!tempuser.equals(null))
            		bookModel1.setUserId(tempuser);
            	
            	System.out.println("in book controller    " + tempuser.getUserId() );  
            	System.out.println("7" );
            	
            	JPACategoryDAO objCat= new JPACategoryDAO();
            	category tempCat = objCat.getCategory( categoryId);
            	if(!tempCat.equals(null))
            		bookModel1.setCategoryId(tempCat);
            	
                
                ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "title", "title", "Title can't be empty");
                ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"author","author", "Author can't be empty");
                ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "isbn", "isbn", "ISBN can't be empty");
                ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"description","description", "Description can't be empty");
                ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult,"condition","condition", "Condition can't be empty");
                ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "pickupAddress", "pickupAddress", "Pickup Address can't be empty");
                ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "price", "price", "Price can't be empty");
                
                if(categoryId == 0)
                	ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "category", "category", "category can't be empty");
                
                
                System.out.println("2" );
                
                if (bindingResult.hasErrors())
                {
                    
                	
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
                	//bookModel1.setActive(1);
                	//bookModel1.setStatus("New");
                	
                	
                	System.out.println("6 " + bookModel1.getBookId() + " --" );
                	//Integer.parseInt(session.getAttribute("userId").toString())
                	
                	System.out.println("returnd cat id is "  + bookModel1.getActive());
                  	 
                	
                	
                	JPABookDAO obj= new JPABookDAO();
                	book updateBookObj = obj.getBook(bookModel1.getBookId());
                	
                	
                	updateBookObj.setActive(bookModel1.getActive());
                	updateBookObj.setAuthor(bookModel1.getAuthor());
                	updateBookObj.setCategoryId(bookModel1.getCategoryId());
                	updateBookObj.setCondition(bookModel1.getCondition());
                	updateBookObj.setDescription(bookModel1.getDescription());
                	updateBookObj.setIsbn(bookModel1.getIsbn());
                	updateBookObj.setKeywords(bookModel1.getKeywords());
                	updateBookObj.setPickupAddress(bookModel1.getPickupAddress());
                	updateBookObj.setPictureId(bookModel1.getPictureId());
                	updateBookObj.setPrice(bookModel1.getPrice());
                	updateBookObj.setStatus(bookModel1.getStatus());
                	updateBookObj.setTitle(bookModel1.getTitle());
                	obj= new JPABookDAO();
                	obj.update(updateBookObj);
                	
                	if(bookModel1.getActive() == 0)
                	{
		                	//user statistics change -- deleted, seller
							JPAUserStatisticsDAO objUserStat = new JPAUserStatisticsDAO();
			            	statistics userStatistics = new statistics();
			            	userStatistics = objUserStat.getUserStatisticsByUser(15); //session
			            	int noOfBookDeleted = userStatistics.getNoOfBookDeleted();
			            	userStatistics.setNoOfBookDeleted(noOfBookDeleted + 1);
			            	objUserStat = new JPAUserStatisticsDAO();
			            	
			            	objUserStat.update(userStatistics);
                	}
                	
                	msg="Your book is updation successfully";
                	ModelAndView mv = new ModelAndView();
                	mv.addObject("redirectTo", "./bookhome");
                	mv.addObject("redirectToBuy", "./purchase");
	            	mv.addObject("catId", bookModel1.getCategoryId().getName());
	                mv.addObject("bookdetails", bookModel1);
	                mv.setViewName("showbook");
	           	 	return mv;
              }
            } catch (Exception e) {
                System.out.println("Exception in FirstController "+e.getMessage());
                e.printStackTrace();
                return new ModelAndView("bookhome", "bookdetails", bookModel1);
            }









































    	}
        
    }
    
    

    
    @RequestMapping(value = "/uploadImage/{bookId}", method = RequestMethod.POST)

    public String BookImageSave(HttpServletRequest request,



























            @ModelAttribute("uploadForm") BookImageUpload uploadForm,@PathVariable int bookId) throws IllegalStateException, IOException {
        
    	ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
       // System.out.println("appPath = " + appPath);
 
        // construct the complete absolute path of the file
        String fullPath = appPath + imagePath +  "\\" + bookId + "\\" ;   
    	
    	
    	//String saveDirectory = imagePath + "";
 
        MultipartFile bookImage = uploadForm.getFile();
 
        
 
        if (null != bookImage && bookImage.getSize() > 0) {
            

 
                String fileName = bookImage.getOriginalFilename();
                
                if (!"".equalsIgnoreCase(fileName)) {
                	bookImage.transferTo(new File(fullPath + bookId + ".jpg"));
                    
                }
            






















































































        }
 
        
        return "uploadfilesuccess";
    }


   

}