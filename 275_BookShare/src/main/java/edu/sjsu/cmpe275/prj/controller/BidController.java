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

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.sjsu.cmpe275.prj.dao.*;
import edu.sjsu.cmpe275.prj.models.Login;
import edu.sjsu.cmpe275.prj.models.bid;
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
public class BidController 
{
	@Autowired
	private HttpSession httpSession;
	  private user userModel;
	    private book bookModel;
	    private category categoryModel;
	    HttpSession session;
	    private feedback feedbackbuyerModel;
	    private transaction transaction;
	    List<feedback> str;
	    
	    @RequestMapping(value = "/book/bid/{biId}",method = RequestMethod.GET)
	    public ModelAndView seeBid(@PathVariable int buyerId) 
	    {
	    	JPABidDAO j=new JPABidDAO();
	    	List<bid> bids = j.getBidByBookId(Integer.parseInt((String) httpSession.getAttribute("BOOKID")));
	    	
	       ModelAndView model = new ModelAndView("bidModel");
	      
	       if(bids.size() > 0)
	       {
	    	   model.addObject("buyer", bids.get(0).getBuyer());
	    	   model.addObject("seller", bids.get(0).getSeller());
	       }
	       model.addObject("bids", bids);
	       model.setViewName("bid.jsp");
			return model;

	    }
	    
	    @RequestMapping(value = "/book/bid/{biId}",method = RequestMethod.POST)
	    public ModelAndView Bid(@PathVariable bid bid) 
	    {
	    	JPABidDAO j=new JPABidDAO();
	    	j.updateBid(bid);
	    	
	       ModelAndView model = new ModelAndView("bidModel");
	       model.setViewName("bid.jsp");
	      
	       model.addObject("bids", bid);
			return model;

	    }
	    
	    
	    @RequestMapping(value = "/book/{bid}/deleteBid",method = RequestMethod.GET)
	    public ModelAndView deleteBid(@PathVariable bid bid) 
	    {
	    	JPABidDAO j=new JPABidDAO();
	    	j.delete(bid);
	    	
	       ModelAndView model = new ModelAndView("bidModel");
	      
	      model.setViewName("bid.jsp");
	       model.addObject("bids", bid);
			return model;
	    	
	    }
	    
	    @RequestMapping(value = "/book/bid/insertBid",method = RequestMethod.GET)
	    public ModelAndView insertBid() 
	    {
	    	JPABookDAO jpbook = new JPABookDAO();
	    	int bookId=Integer.parseInt(httpSession.getAttribute("BOOKID").toString());
	    	int userIdBuyer=Integer.parseInt(httpSession.getAttribute("USERID_B").toString());
	    	int userIdSeller=Integer.parseInt(httpSession.getAttribute("USERID_S").toString());
	    	JPAUserDAO jpuser = new JPAUserDAO();
	    	bid Bid = new bid();
	    	Bid.setActive(1);
	    	Bid.setBook(jpbook.getBook(bookId));
	    	Bid.setBuyer(jpuser.getUser(userIdBuyer));
	    	Bid.setSeller(jpuser.getUser(userIdSeller));
	    	JPABidDAO j=new JPABidDAO();
	    	j.insert(Bid);
	    	
	       ModelAndView model = new ModelAndView("bidModel");
	      
	       model.setViewName("bid.jsp");
	       model.addObject("Bids", Bid);
			return model;
	    	
	    }
	    
	    
}
