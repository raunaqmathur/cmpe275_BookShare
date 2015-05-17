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
	
	public feedback getFeedbackByTransaction(int txId) 
	{
		feedback tempFeedbackBuyer = new feedback();
		try {
			DBCrud<feedback> db = new DBCrud<feedback>();
			tempFeedbackBuyer=  db.getFeedbackByTransaction(txId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempFeedbackBuyer;
	}

	public int insert(feedback feedback) {
		System.out.println("in feedback jpa");
		int feedbackId= 0;
		try {
			DBCrud<feedback> db = new DBCrud<feedback>();
			feedbackId = db.Insert(feedback);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return feedbackId;
	}

	public void delete(feedback feedback) {
		// TODO Auto-generated method stub
		
	}

	public void update(feedback feedback) {
		try {
			DBCrud<feedback> db = new DBCrud<feedback>();
			db.update(feedback);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
