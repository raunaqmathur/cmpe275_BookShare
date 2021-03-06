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
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.feedback;

import edu.sjsu.cmpe275.prj.models.requestbook;
import edu.sjsu.cmpe275.prj.models.transaction;
import edu.sjsu.cmpe275.prj.models.user;
import edu.sjsu.cmpe275.prj.utils.PlayPP;
import edu.sjsu.cmpe275.prjservices.UserRecordService;

@SuppressWarnings("unused")
@Controller
public class FeedbackController 
{
	@Autowired
	private HttpSession httpSession;
	private user userModel;
	private book bookModel;
	private category categoryModel;
	HttpSession session;
	private feedback feedbackbuyerModel;
	private transaction transaction;
	private List<feedback> feedbacks;
	    
    @RequestMapping(value = "/feedbackasbuyer/{buyerId}",method = RequestMethod.GET)
    public ModelAndView uploadFeedback(@PathVariable int buyerId) {
    	JPAFeedbackDAO j = new JPAFeedbackDAO();
	    feedbacks = j.getFeedbackBuyer(buyerId);
	    ModelAndView model = new ModelAndView("feedbackAsBuyer");
	    model.addObject("str", feedbacks);
		return model;
	}
	    
	@RequestMapping(value = "/feedbackasseller/{sellerId}",method = RequestMethod.GET)
	public ModelAndView uploadFeedbackSeller(@PathVariable int sellerId) {
		JPAFeedbackDAO j = new JPAFeedbackDAO();
		feedbacks = j.getFeedbackSeller(sellerId);
	    ModelAndView model = new ModelAndView("feedbackAsSeller");
	    model.addObject("str", feedbacks);
		return model;
	}
	    
	@RequestMapping(value = "/feedback/{feedbackType}/{txId}",method = RequestMethod.GET)
	public ModelAndView giveFeedback(@PathVariable String feedbackType, @PathVariable int txId) {
		
		int userId = Integer.parseInt(httpSession.getAttribute("USERID").toString());
		JPATransactionDAO obj= new JPATransactionDAO();
		transaction tx = new transaction();
		tx=obj.getTransaction(txId);
	
		boolean trueUser = true;
		if(feedbackType.equals("buyer")) {
			if(tx.getUser().getUserId() != userId)
				trueUser = false;
		} else {
			if(tx.getBook().getUserId().getUserId() != userId)
				trueUser = false;
		}
	
		if(trueUser == false) 
			return new ModelAndView("redirect:/login");
		else {
	    	feedback feedbackModel = new feedback();
	    	feedbackModel.setTransactionId(tx);
	    	ModelAndView model = new ModelAndView("provideFeedback");
	    	model.addObject("feedbackModelDetails", feedbackModel);
			return model;
		}
	}
	
	@RequestMapping(value = "/insertfeedback",method = RequestMethod.POST)
	public ModelAndView insertFeedback(@ModelAttribute("feedbackModelDetails")feedback feedbackModel1, BindingResult bindingResult, 
	            HttpServletRequest request,  HttpServletResponse response,
	            @RequestParam(value="transactionId") int txId) {
		try {

			int userId = Integer.parseInt(httpSession.getAttribute("USERID").toString());
	    	JPATransactionDAO obj= new JPATransactionDAO();
	    	transaction tx = new transaction();
	    	tx = obj.getTransaction(txId);
		    	
		    boolean trueUser = false;
		    
    		if(tx.getUser().getUserId() == userId)
    			trueUser = true;
    		else if(tx.getBook().getUserId().getUserId() == userId)
    			trueUser = true;
    		
		    if(trueUser == false)		    		
		 		return new ModelAndView("redirect:/login");
		    else {
	    		JPAUserDAO objUserDAO = new JPAUserDAO();
	    		user tempUser = objUserDAO.getUser(userId);
	    		
	    		JPAFeedbackDAO objFeedDAO = new JPAFeedbackDAO();
	    		feedback fTemp = new feedback();
		    		
		    	fTemp = objFeedDAO.getFeedbackByTransaction(txId);
		    	if(fTemp != null) {
		    		if(fTemp.getFeedbackId() != 0) {
		    			if(tx.getUser().getUserId() == userId) {
	    					fTemp.setBuyerId(tempUser);
	    					fTemp.setBuyerComments(request.getParameter("comment"));
	    					fTemp.setBuyerRating(Integer.parseInt(request.getParameter("rating")));
	    					objFeedDAO = new JPAFeedbackDAO();
	    					objFeedDAO.update(fTemp);
	    					obj= new JPATransactionDAO();
	    			    	tx.setBuyerFeedback(1);
	    			    	obj.update(tx);
	    					System.out.println("Updated Buyer Comment");
	    					return new ModelAndView("redirect:/transactions");
		    			} else {
		    				if(tx.getBook().getUserId().getUserId() == userId) {
	    						fTemp.setSellerId(tempUser);
		    					fTemp.setSellerComments(request.getParameter("comment"));
		    					fTemp.setSellerRating(Integer.parseInt(request.getParameter("rating")));
		    					objFeedDAO = new JPAFeedbackDAO();
		    					objFeedDAO.update(fTemp);
		    					obj= new JPATransactionDAO();
		    			    	tx.setSellerFeedback(1);
		    			    	obj.update(tx);			    			    	
		    					System.out.println("Updated Seller Comment");
		    					return new ModelAndView("redirect:/transactions");
			    			} else {
	    						System.out.println("return to login from 2" );
	    						return new ModelAndView("redirect:/login");
		    				}
		    			}
		    		} else {
		    			//insert
	    				fTemp = new feedback();
	    				if(tx.getUser().getUserId() == userId) {
	    					fTemp.setBuyerId(tempUser);
	    					fTemp.setBuyerComments(request.getParameter("comment"));
	    					fTemp.setBuyerRating(Integer.parseInt(request.getParameter("rating")));
	    					objFeedDAO = new JPAFeedbackDAO();
	    					objFeedDAO.insert(fTemp);
	    					obj= new JPATransactionDAO();
	    			    	tx.setBuyerFeedback(1);
	    			    	obj.update(tx);
	    					System.out.println("Inserted Buyer Comment" );
	    					return new ModelAndView("redirect:/transactions");
	    				} else {
		    				if(tx.getBook().getUserId().getUserId() == userId) {
	    						fTemp.setSellerId(tempUser);
		    					fTemp.setSellerComments(request.getParameter("comment"));
		    					fTemp.setSellerRating(Integer.parseInt(request.getParameter("rating")));
		    					objFeedDAO = new JPAFeedbackDAO();
		    					objFeedDAO.insert(fTemp);
		    					obj= new JPATransactionDAO();
		    					tx.setSellerFeedback(1);
		    			    	obj.update(tx);
		    					System.out.println("Inserted Seller Comment" );
		    					return new ModelAndView("redirect:/transactions");
		    				} else {
	    						System.out.println("return to login from 3" );
	    						return new ModelAndView("redirect:/login");
		    				}
		    			}
		    		}
		    	} else {		    			
	    			//insert
    				fTemp = new feedback();
    				fTemp.setTransactionId(tx);
    				if(tx.getUser().getUserId() == userId) {
    					fTemp.setBuyerId(tempUser);
    					fTemp.setBuyerComments(request.getParameter("comment"));
    					fTemp.setBuyerRating(Integer.parseInt(request.getParameter("rating")));
    					objFeedDAO = new JPAFeedbackDAO();
    					objFeedDAO.insert(fTemp);
    					obj= new JPATransactionDAO();
    			    	tx.setBuyerFeedback(1);
    			    	obj.update(tx);
    					System.out.println("Inserted Buyer Comment from null");
    					return new ModelAndView("redirect:/transactions");
    				} else {
	    				if(tx.getBook().getUserId().getUserId() == userId) {
    						fTemp.setSellerId(tempUser);
	    					fTemp.setSellerComments(request.getParameter("comment"));
	    					fTemp.setSellerRating(Integer.parseInt(request.getParameter("rating")));
	    					objFeedDAO = new JPAFeedbackDAO();
	    					objFeedDAO.insert(fTemp);
	    					obj= new JPATransactionDAO();
	    			    	tx.setSellerFeedback(1);
	    			    	obj.update(tx);
	    					System.out.println("Inserted Seller Comment from null");
	    					return new ModelAndView("redirect:/transactions");
	    				} else {
    						System.out.println("return to login from 4" );
    						return new ModelAndView("redirect:/login");
    					}
	    			}
		    	}
		    }
        } catch (Exception e) {
            System.out.println("Exception in FeedbackController "+e.getMessage());
            e.printStackTrace();
            return new ModelAndView("error404");
        }
	}  
}
