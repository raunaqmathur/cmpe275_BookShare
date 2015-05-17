package edu.sjsu.cmpe275.prj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import edu.sjsu.cmpe275.prj.dao.*;
import edu.sjsu.cmpe275.prj.models.Login;
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.BookImageUpload;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.internalCategory;
import edu.sjsu.cmpe275.prj.models.transaction;
import edu.sjsu.cmpe275.prj.models.statistics;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prj.utils.CheckSession;
import edu.sjsu.cmpe275.prjservices.UserRecordService;
 
@SuppressWarnings("unused")
@Controller
public class TransactionController {
 
	@Autowired
	private HttpSession httpSession;
	
   	@Autowired
   	private CheckSession sessionService;
   	
    @RequestMapping(value = "/transactions",method = RequestMethod.GET)
    public Object getTransactionsOfUser() {
    	
    	if(!sessionService.checkAuth()) {
    		System.out.println("chk class wrked!");
    		Login login = new Login();
    		return "redirect:/login";    		
    	}
    	
    	int userId = Integer.parseInt(httpSession.getAttribute("USERID").toString());
    	JPATransactionDAO obj = new JPATransactionDAO();
    	List<transaction> txListAsSeller = new ArrayList<transaction>();
    	List<transaction> txListAsBuyer = new ArrayList<transaction>();
    	txListAsSeller = obj.getTransactionByUserAsSeller(userId);
    	txListAsBuyer = obj.getTransactionByUserAsBuyer(userId);
    	ModelAndView model = new ModelAndView("transactions");
        model.addObject("strSeller", txListAsSeller);
        model.addObject("strBuyer", txListAsBuyer);
		return model;
    }
    
    @RequestMapping(value = "/currenttransactions/{txId}",method = RequestMethod.GET)
    public Object getCurrentTransactionsOfUser(@PathVariable int txId) {
    	if(!sessionService.checkAuth()) {
    		System.out.println("chk class wrked!");
    		Login login = new Login();
    		return "redirect:/login";
    	}

    	JPATransactionDAO obj= new JPATransactionDAO();
    	transaction txList = new transaction();
    	txList=obj.getCurrentTransactionByUser(txId);
    	System.out.println("in curenttransaction: " +txList.getTransactionId() );
        ModelAndView model = new ModelAndView();
        model.setViewName("txn");
        model.addObject("result", txList);
		return model;
    }
    
    
    @RequestMapping(value = "/searchTransaction/{txId}",method = RequestMethod.GET)
    @ResponseBody
    public String searchTransactions(@PathVariable int txId) {
    	int userId = Integer.parseInt(httpSession.getAttribute("USERID").toString());
    	JPATransactionDAO obj= new JPATransactionDAO();
    	transaction txList = new transaction();
    	txList=obj.getCurrentTransactionByUser(txId);
    	System.out.println("in searchtransaction: " + txList.getTransactionId());
    	String model = "";
    	
        if(txList.getBook().getUserId().getUserId() == userId || txList.getUser().getUserId() == userId) {
        	model = "Transaction Id: " + txList.getTransactionId() 
       		   + " <br/>" + "Book Id: " + txList.getBook().getBookId() 
    		   + " <br/>" + "Book Title: " + txList.getBook().getTitle()
    		   + " <br/>" + "Price: " + txList.getPrice()
    		   + " <br/>" + "Transaction time: " + txList.getTransactionTime();
       
    	   	if(txList.getBook().getUserId().getUserId() == userId)
    	   		model+= " <br/>" + "Buyer: " + txList.getUser().getName();
    	   	else
    	   		model+= " <br/>" + "Seller: " + txList.getBook().getUserId().getName();
        } else
        	model = "";
        System.out.println("in searchtransaction: " + model );
		return model;
    }

    @RequestMapping(value = "/purchase/{bookId}",method = RequestMethod.GET)
    public Object bookTransaction(@PathVariable int bookId) {
    	if(!sessionService.checkAuth()) {
    		System.out.println("chk class wrked!");
    		Login login = new Login();
    		return "redirect:/login";
    	}
    	ModelAndView mv = new ModelAndView();
    	book bookModel1 = new book();
    	JPABookDAO objBook= new JPABookDAO();
    	bookModel1 = objBook.getBook(bookId);
    	int txId = 0;
    	try {
    		JPATransactionDAO obj= new JPATransactionDAO();
			System.out.println("in transaction: " +bookModel1.getBookId());
			objBook = new JPABookDAO();
	    	bookModel1.setStatus("Sold");
	    	objBook.update(bookModel1);
			JPAUserDAO objUser= new JPAUserDAO();
	    	user tempuser = objUser.getUser(Integer.parseInt(httpSession.getAttribute("USERID").toString()));
			transaction newTransaction = new transaction();
			
			if(!tempuser.equals(null))
				newTransaction.setUser(tempuser);
			
			newTransaction.setBook(bookModel1);
			newTransaction.setPrice(bookModel1.getPrice());
			newTransaction.setTransactionTime((new Date()));
				
			obj.insert(newTransaction);
			txId = newTransaction.getTransactionId();
				
			//user statistics change -- Buyer
			JPAUserStatisticsDAO objUserStat = new JPAUserStatisticsDAO();
        	statistics userStatistics = new statistics();
        	userStatistics = objUserStat.getUserStatisticsByUser(Integer.parseInt(httpSession.getAttribute("USERID").toString())); //session
        	int noOfBookPurchased = userStatistics.getNoOfBookPurchased();
        	userStatistics.setNoOfBookPurchased(noOfBookPurchased + 1);
        	objUserStat = new JPAUserStatisticsDAO();
        	
        	objUserStat.update(userStatistics);

        	//user statistics change -- Seller
			objUserStat = new JPAUserStatisticsDAO();
        	userStatistics = new statistics();
        	userStatistics = objUserStat.getUserStatisticsByUser(bookModel1.getUserId().getUserId()); //session
        	int noOfBookTransac = userStatistics.getNoOfBookTransac();
        	userStatistics.setNoOfBookTransac(noOfBookTransac + 1);
        	objUserStat = new JPAUserStatisticsDAO();
        	objUserStat.update(userStatistics);
				
		} catch (Exception e) {
	        System.out.println("Exception in transactionController "+e.getMessage());
	        e.printStackTrace();
	        mv.addObject("catId", bookModel1.getCategoryId().getName());
	        mv.addObject("bookdetails", bookModel1);
	        mv.setViewName("showbook");
	        return mv;
    	}
    	
    	int userId = Integer.parseInt(httpSession.getAttribute("USERID").toString());
    	System.out.println("redirectingX to transcations "+ userId);
        return new ModelAndView("redirect:/currenttransactions/" + txId);
    }

}