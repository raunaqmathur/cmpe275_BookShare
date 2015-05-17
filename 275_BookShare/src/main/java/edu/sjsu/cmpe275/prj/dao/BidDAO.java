package edu.sjsu.cmpe275.prj.dao;

import java.util.List;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface BidDAO {
	public List<bid> getBidByBookId(int bookId);
	

	
}
