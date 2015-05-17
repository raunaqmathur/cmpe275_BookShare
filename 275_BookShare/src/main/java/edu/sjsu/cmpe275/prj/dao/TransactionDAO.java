package edu.sjsu.cmpe275.prj.dao;

import java.util.List;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface TransactionDAO {
	public int insert(transaction transaction);
	public void delete(transaction transaction);
	public void update(transaction transaction);
	public transaction getTransaction(int transactionId);
	public List<transaction> getTransactionByUser(int userId);
	
}
