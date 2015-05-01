package edu.sjsu.cmpe275.prj.dataoperations;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	public long Insert(T obj){
		System.out.println("in crud");
		long id = 0;
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		if(obj instanceof user){
			user p = (user)obj;
			id = p.getUserId();
		}
		/*else if(obj instanceof Sponsor){
			Sponsor s = (Sponsor)obj;
			id = s.getId();
		}
		else if(obj instanceof Address){
			Address s = (Address)obj;
			id = s.getId();
		}*/
		
		session.close();
		s.close();
		
		return id;
	}
	
	
	/*
	 * Function to reterieve tuple from database
	 * 
	 */
	@SuppressWarnings("unchecked")
	public T get(T obj, long id){
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

	
	/*
	 * Function to get count
	 * of sponsor in player table
	 */
/*	public int getSponsor(long sponsorId){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from player s where s.sponsor_id = :sCode")
				.addEntity(user.class)
				.setParameter("sCode", sponsorId);
				int  result = query.list().size();
		session.close();
		s.close();
		return result;
	}
	*/
}