package edu.sjsu.cmpe275.prj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
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
import edu.sjsu.cmpe275.prj.models.Book;
import edu.sjsu.cmpe275.prj.models.BookImageUpload;
import edu.sjsu.cmpe275.prj.models.Category;
import edu.sjsu.cmpe275.prj.models.HomePageModel;
import edu.sjsu.cmpe275.prj.models.Transaction;
import edu.sjsu.cmpe275.prj.models.UserStatistics;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class TransactionController {
 
    
    
   
    
   
	
   // private user userModel;
    
    //private Book bookModel;
   // private Category categoryModel;
    HttpSession session;
    
  
    
    
    @RequestMapping(value = "/purchase/{bookId}",method = RequestMethod.GET)
    public ModelAndView bookTransaction(@PathVariable int bookId) {
    	ModelAndView mv = new ModelAndView();
    	//System.out.println("in transaction: " +bookModel1.getBookId() );
    	Book bookModel1 = new Book();
    	JPABookDAO objBook= new JPABookDAO();
    	bookModel1 = objBook.getBook(bookId);
    	try
    	{
	    		
		    	JPATransactionDAO obj= new JPATransactionDAO();
		    	
				System.out.println("in transaction: " +bookModel1.getBookId() );
				
				JPAUserDAO objUser= new JPAUserDAO();
		    	user tempuser = objUser.getUser(11);//session
		    	
				
				
				
				Transaction newTransaction = new Transaction();
				if(!tempuser.equals(null))
					newTransaction.setUser(tempuser);
				
				newTransaction.setActive(1);
			
				newTransaction.setBook(bookModel1);
				newTransaction.setPrice(bookModel1.getPrice());
				newTransaction.setTransactionTime((new Date()));
				
				obj.insert(newTransaction);
				
				//user statistics change -- Buyer
				JPAUserStatisticsDAO objUserStat = new JPAUserStatisticsDAO();
            	UserStatistics userStatistics = new UserStatistics();
            	userStatistics = objUserStat.getUserStatisticsByUser(11); //session
            	int noOfBookPurchased = userStatistics.getNoOfBookPurchased();
            	userStatistics.setNoOfBookPurchased(noOfBookPurchased + 1);
            	objUserStat = new JPAUserStatisticsDAO();
            	
            	objUserStat.update(userStatistics);
            	
            	
            	//user statistics change -- Seller
				 objUserStat = new JPAUserStatisticsDAO();
            	userStatistics = new UserStatistics();
            	userStatistics = objUserStat.getUserStatisticsByUser(bookModel1.getUserId().getUserId()); //session
            	int noOfBookTransac = userStatistics.getNoOfBookTransac();
            	userStatistics.setNoOfBookTransac(noOfBookTransac + 1);
            	objUserStat = new JPAUserStatisticsDAO();
            	objUserStat.update(userStatistics);
            	
            	
            	
				
		}
    	catch (Exception e) {
	        System.out.println("Exception in transactionController "+e.getMessage());
	        e.printStackTrace();
	        mv.addObject("catId", bookModel1.getCategoryId().getName());
	        mv.addObject("bookdetails", bookModel1);
	        mv.setViewName("showbook");
	        
	       return mv;
    	}
    	mv.addObject("catId", bookModel1.getCategoryId().getName());
        mv.addObject("bookdetails", bookModel1);
        mv.setViewName("showbook");
        
       return mv;
    }
    
    

}