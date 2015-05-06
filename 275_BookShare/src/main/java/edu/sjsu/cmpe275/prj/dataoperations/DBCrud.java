package edu.sjsu.cmpe275.prj.dataoperations;





import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.sjsu.cmpe275.prj.models.Login;
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.feedback;
import edu.sjsu.cmpe275.prj.models.requestBook;
import edu.sjsu.cmpe275.prj.models.transaction;
import edu.sjsu.cmpe275.prj.models.statistics;
import edu.sjsu.cmpe275.prj.models.user;

/*
 * Class to perform database operation using sessionfactory object
 * perform Create, read, update, delete operation
 */
@SuppressWarnings("unused")
public class DBCrud<T> {
	Session session;
	SessionFactory s;
	public DBCrud(){}
	
	
	/*
	 * Function to save new record
	 * 
	 */
	public int Insert(T obj){
		System.out.println("in crud");
		int id = 0;

		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		if(obj instanceof user){
			user p = (user)obj;
			id = p.getUserId();
		}
		else if(obj instanceof category){
			category s = (category)obj;
			id = s.getCategoryId();
			System.out.println("in crud category " + id);
		}
		else if(obj instanceof book){
			book s = (book)obj;
			id = s.getBookId();
			System.out.println("in crud book " + id);
		}
		else if(obj instanceof requestBook){
			requestBook s = (requestBook)obj;
			id = s.getRequestId();


			System.out.println("in crud book " + id);
		}
		
		else if(obj instanceof feedback){
			feedback s = (feedback)obj;
			id = s.getFeedbackId();


			System.out.println("in crud book " + id);
		}
		
		
		else if(obj instanceof transaction){


			transaction s = (transaction)obj;
			id = s.getTransactionId();
			System.out.println("in crud transaction " + id);
		}

		else if(obj instanceof statistics){


			statistics s = (statistics)obj;
			id = s.getUsId();
			System.out.println("in crud statistics " + id);
		}
		session.close();
		s.close();
		
		return id;
	}
	
	
	/*
	 * Function to reterieve tuple from database
	 * 
	 */
	@SuppressWarnings("unchecked")
	public T get(T obj, int id){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		T newR;
		newR = (T)session.get(obj.getClass(), id);
		
		session.close();
		s.close();
		
		return newR;
	}
	
	
	/*
	 * Function to update a tuple
	 * 
	 */
	public void update(T obj){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		session.close();
		s.close();
	}
	
	
	/*
	 * Function to delete a tuple
	 * 
	 */
	public void delete(T obj){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		session.close();
		s.close();
	}

	
	
	public int getExistingEmail(String emailId){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from user  where EmailID = :sCode")
				.addEntity(user.class)
				.setParameter("sCode", emailId);
				int  result = query.list().size();
		session.close();
		s.close();
		
		System.out.println("----" + result);
		return result;
	}

	
	@SuppressWarnings("unchecked")
	public List<feedback> getSellerComments(int buyerID){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from feedback  where BuyerID = :sCode")
				.addEntity(feedback.class)
				.setParameter("sCode", buyerID);
				List<feedback>  result = (List<feedback>)query.list();
		session.close();
		s.close();
		
		System.out.println("----" + result);
		return result;
	}
	
@SuppressWarnings("unchecked")
	public List<feedback> getBuyerComments(int sellerID){

		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();

		Query query = session.createSQLQuery(
				"select * from feedback  where SellerID = :sCode")
				.addEntity(feedback.class)
				.setParameter("sCode", sellerID);
				List<feedback>  result = (List<feedback>)query.list();




		session.close();
		s.close();
		
		System.out.println("----" + result);
		return result;
	}

	@SuppressWarnings("unchecked")

	public T getUserStatisticsByUser(int userId){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		T obj = null;
		Query query = session.createSQLQuery(
				"select * from statistics  where UserId = :sCode")
				.addEntity(statistics.class)
				.setParameter("sCode", userId);
				int  result = query.list().size();
				
		if(result > 0)
			obj = (T)query.list().get(0);
		
		session.close();
		s.close();
		
		System.out.println("----" + result);
		return obj;
	}

	@SuppressWarnings("unchecked")
<<<<<<< HEAD
	public List<category> getCategories(){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();

		Query query = session.createSQLQuery("select * from category").addEntity(category.class);
		
		List<category> result = (List<category>)query.list();
		session.close();
		s.close();
		
		System.out.println("----" + result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<book> getBooks(){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from book").addEntity(book.class);		
		List<book> result = (List<book>)query.list();
		session.close();
		s.close();		
		System.out.println("----" + result);
=======
	public int validate(Login login){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		
		Query query = session.createSQLQuery(
				"select * from user  where UserId = :sCode and password = :jCode")
				.addEntity(user.class)
				.setParameter("sCode", login.getUserId())
				.setParameter("jCode", login.getPassword());
		
		
				int  result = query.list().size();
				
		
		session.close();
		s.close();
		
		System.out.println("login - " + result);
>>>>>>> parent of cbd5675... Revert "Merge remote-tracking branch 'origin/master'"
		return result;
	}
}