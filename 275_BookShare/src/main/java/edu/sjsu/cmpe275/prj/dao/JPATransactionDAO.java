package edu.sjsu.cmpe275.prj.dao;

import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.Category;
import edu.sjsu.cmpe275.prj.models.Transaction;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPATransactionDAO implements TransactionDAO{

	
	/*
	 * Function to add address
	 * 
	 */
	
	public int insert(Transaction transaction) 
	{
		System.out.println("in transaction jpa");
		int transactionId= 0;
		try {
			DBCrud<Transaction> db = new DBCrud<Transaction>();
			transactionId = db.Insert(transaction);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return transactionId;
	}

	
	/*
	  * function to update address tuple n the database 
	  * 
	  */
	public void update(Transaction transaction) {
		
		
				try {
					DBCrud<Transaction> db = new DBCrud<Transaction>();
					db.update(transaction);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}

	
	/*
	 * Function to delete address from databse
	 * 
	 */
	public void delete(Transaction transaction) {
		
		
		
		try {
			DBCrud<Transaction> db = new DBCrud<Transaction>();
			db.delete(transaction);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


	/*
	 * Function to delete address from database
	 * 
	 */
	


	public Transaction getTransaction(int transactionId) {
		Transaction result = new Transaction();
		
		try {
			DBCrud<Transaction> db = new DBCrud<Transaction>();
			result = db.get(result,transactionId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}


	
}
