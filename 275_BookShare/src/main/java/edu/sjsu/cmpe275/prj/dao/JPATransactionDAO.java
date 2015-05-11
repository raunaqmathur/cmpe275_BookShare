package edu.sjsu.cmpe275.prj.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.transaction;


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
	public int insert(transaction transaction) {
		System.out.println("in transaction jpa");
		int transactionId = 0;
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			transactionId = db.Insert(transaction);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return transactionId;
	}

	/*
	  * function to update address tuple n the database 
	  * 
	  */
	public void update(transaction transaction) {
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			db.update(transaction);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * Function to delete address from database
	 * 
	 */
	public void delete(transaction transaction) {
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			db.delete(transaction);	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * Function to delete address from database
	 * 
	 */
	public transaction getTransaction(int transactionId) {
		transaction result = new transaction();
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			result = db.get(result,transactionId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	public List<transaction> getTransactionByUser(int userId) {
		return null;
	}
	
	public List<transaction> getTransactionByUserAsBuyer(int userId) {
		List<transaction> lstTrx = new ArrayList<transaction>();
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			lstTrx = db.getTransactionByUserAsBuyer(userId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return lstTrx;
	}
	
	public List<transaction> getTransactionByUserAsSeller(int buyerId) {
		List<transaction> lstTrx = new ArrayList<transaction>();
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			lstTrx = db.getTransactionByUserAsSeller(buyerId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return lstTrx;
	}

	public transaction getCurrentTransactionByUser(int userId) {
		transaction lstTrx = new transaction();
		try {
			DBCrud<transaction> db = new DBCrud<transaction>();
			lstTrx = db.getCurrentTransactionByUser(userId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return lstTrx;
	}
}
