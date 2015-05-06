package edu.sjsu.cmpe275.prj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.feedback;

public class JPAFeedbackDAO implements FeedbackDAO {

	public List<feedback> getFeedbackBuyer(int BuyerId) 
	{
		List<feedback> tempFeedbackBuyer = new ArrayList<feedback>();
		try {
			DBCrud<feedback> db = new DBCrud<feedback>();
			tempFeedbackBuyer=  db.getSellerComments(BuyerId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempFeedbackBuyer;
	}
	
	public List<feedback> getFeedbackSeller(int sellerId) 
	{
		List<feedback> tempFeedbackBuyer = new ArrayList<feedback>();
		try {
			DBCrud<feedback> db = new DBCrud<feedback>();
			tempFeedbackBuyer=  db.getBuyerComments(sellerId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempFeedbackBuyer;
	}
	

}
