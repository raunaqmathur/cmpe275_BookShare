package edu.sjsu.cmpe275.prj.dao;


import java.util.List;

import edu.sjsu.cmpe275.prj.models.feedback;

public interface FeedbackDAO {
	
	public List<feedback> getFeedbackBuyer(int BuyerID);
	
	public List<feedback> getFeedbackSeller(int sellerId);

}
