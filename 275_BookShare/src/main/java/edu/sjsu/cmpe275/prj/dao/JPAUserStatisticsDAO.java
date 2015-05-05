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
import edu.sjsu.cmpe275.prj.models.UserStatistics;


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
	
	public int insert(UserStatistics userStatistics) 
	{
		System.out.println("in UserStatistics jpa");
		int userStatisticsId= 0;
		try {
			DBCrud<UserStatistics> db = new DBCrud<UserStatistics>();
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
	public void update(UserStatistics userStatistics) {
		
		System.out.println("in update UserStatistics jpa");
				try {
					DBCrud<UserStatistics> db = new DBCrud<UserStatistics>();
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
	public void delete(UserStatistics userStatistics) {
		
		
		
		try {
			DBCrud<UserStatistics> db = new DBCrud<UserStatistics>();
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
	


	public UserStatistics getUserStatistics(int userStatisticsId) {
		UserStatistics result = new UserStatistics();
		
		try {
			DBCrud<UserStatistics> db = new DBCrud<UserStatistics>();
			result = db.get(result,userStatisticsId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}


	public UserStatistics getUserStatisticsByUser(int userId) {
			UserStatistics result = new UserStatistics();
		
		try {
			DBCrud<UserStatistics> db = new DBCrud<UserStatistics>();
			result = db.getUserStatisticsByUser(userId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}


	
	
}
