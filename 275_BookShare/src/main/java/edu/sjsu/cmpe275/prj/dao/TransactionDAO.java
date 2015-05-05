package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface TransactionDAO {
	public int insert(Transaction transaction);
	
	
	public void delete(Transaction transaction);
	
	public void update(Transaction transaction);
	
	
	public Transaction getTransaction(int transactionId);
	
	
}
