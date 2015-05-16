package edu.sjsu.cmpe275.prj.dataoperations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.sjsu.cmpe275.prj.models.Login;
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.models.feedback;
import edu.sjsu.cmpe275.prj.models.requestbook;
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
		else if(obj instanceof requestbook){
			System.out.println("in jpa of req.book");
			requestbook s = (requestbook)obj;
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
	 * Function to retrieve tuple from database
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

		return result;
	}
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
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<transaction> getTransactionByUserAsBuyer(int userId){
		System.out.println(" in all transaction ");
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();

		Query query = session.createSQLQuery(
				"select * from transaction where userID = :sCode")
				.addEntity(transaction.class)
				.setParameter("sCode", userId);
				List<transaction> result = (List<transaction>)query.list();
		session.close();
		s.close();	
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<transaction> getTransactionByUserAsSeller(int buyerId){
		System.out.println(" in seller transaction ");
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();

		Query query = session.createSQLQuery(
				"select t.TransactionID, t.userID, t.Price, t.BookID, t.TransactionTime from transaction t, book b  where b.BookID = t.BookID and b.userID = :sCode")
				.addEntity(transaction.class)
				.setParameter("sCode", buyerId);
				List<transaction> result = (List<transaction>)query.list();

		session.close();
		s.close();
		System.out.println(result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public transaction getCurrentTransactionByUser(int userId){
		System.out.println(" in all transaction " );
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();

		Query query = session.createSQLQuery(
				"select * from transaction  where TransactionID = :sCode")
				.addEntity(transaction.class)
				.setParameter("sCode", userId);
				transaction  result = (transaction)query.list().get(0);

		session.close();
		s.close();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<requestbook> getRequestdetails() {
		List<requestbook> result = new ArrayList<requestbook>();
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from requestbook where ParentId=:sCode").addEntity(requestbook.class).setParameter("sCode", 0);
		System.out.println("helo");
		result = (List<requestbook>)query.list();
		session.close();
		s.close();		
		System.out.println("----" + result);
		return result;
	}
	
	//search methods for books
	List<book> listOfbooks = new ArrayList<book>();
	
	@SuppressWarnings("unchecked")
	public List<book> getAllResults(String input) {
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from book where ( title like '%"+input+"%' or author like '%"+input+"%' or keywords like '%"+input+"%' or isbn like '%"+input+"%') and active=1").addEntity(book.class);
		System.out.println("helo search all");
		listOfbooks = (List<book>)query.list();
		session.close();
		s.close();		
		for(int i = 0; i < listOfbooks.size();i++)
			System.out.println("book id got--"+listOfbooks.get(i).getBookId());
		System.out.println("----" + listOfbooks);
		return listOfbooks;
	}
	
	//searches by only book title
	@SuppressWarnings("unchecked")
	public List<book> getResultsByName(String input) {
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from book where  title like '%"+input+"%'  and active=1").addEntity(book.class);
		System.out.println("helo search by title");
		listOfbooks = (List<book>)query.list();
		session.close();
		s.close();		
		System.out.println("----" + listOfbooks);
		return listOfbooks;
	}	
	
	@SuppressWarnings("unchecked")
	public List<book> getResultsByAuthName(String input) {
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from book where author like '%"+input+"%' and active=1").addEntity(book.class);
		System.out.println("helo search by title");
		listOfbooks = (List<book>)query.list();
		session.close();
		s.close();		
		System.out.println("----" + listOfbooks);
		return listOfbooks;
	}
	
	@SuppressWarnings("unchecked")
	public List<book> getResultsByAuthName1(String input) {
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from book where author like '%"+input+"%' and active=1").addEntity(book.class);
		System.out.println("helo search by title");
		listOfbooks = (List<book>)query.list();
		session.close();
		s.close();		
		System.out.println("----" + listOfbooks);
		return listOfbooks;
	}
	
	@SuppressWarnings("unchecked")
	public feedback getFeedbackByTransaction(int txId){
		System.out.println(" in all transaction " );
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		feedback  result = new feedback();
		try
		{
		Query query = session.createSQLQuery(
				"select * from feedback  where TransactionID = :sCode")
				.addEntity(feedback.class)
				.setParameter("sCode", txId);
				  result = (feedback)query.list().get(0);

		}
		catch(Exception ex)
		{
			
			result = null;
		}


		session.close();
		s.close();
		
		
		return result;
	}

}