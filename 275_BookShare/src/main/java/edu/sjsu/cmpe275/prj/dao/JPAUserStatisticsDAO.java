package edu.sjsu.cmpe275.prj.dao;

import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.transaction;
import edu.sjsu.cmpe275.prj.models.statistics;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPAUserStatisticsDAO implements UserStatisticsDAO{

	
	/*
	 * Function to add address
	 * 
	 */
	
	public int insert(statistics userStatistics) 
	{
		System.out.println("in statistics jpa");
		int userStatisticsId= 0;
		try {
			DBCrud<statistics> db = new DBCrud<statistics>();
			userStatisticsId = db.Insert(userStatistics);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return userStatisticsId;
	}

	
	/*
	  * function to update address tuple n the database 
	  * 
	  */
	public void update(statistics userStatistics) {
		
		System.out.println("in update statistics jpa");
				try {
					DBCrud<statistics> db = new DBCrud<statistics>();
					db.update(userStatistics);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}

	
	/*
	 * Function to delete address from databse
	 * 
	 */
	public void delete(statistics userStatistics) {
		
		
		
		try {
			DBCrud<statistics> db = new DBCrud<statistics>();
			db.delete(userStatistics);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


	/*
	 * Function to delete address from database
	 * 
	 */
	


	public statistics getUserStatistics(int userStatisticsId) {
		statistics result = new statistics();
		
		try {
			DBCrud<statistics> db = new DBCrud<statistics>();
			result = db.get(result,userStatisticsId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}


	public statistics getUserStatisticsByUser(int userId) {
			statistics result = new statistics();
		
		try {
			DBCrud<statistics> db = new DBCrud<statistics>();
			result = db.getUserStatisticsByUser(userId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}


	
	
}
