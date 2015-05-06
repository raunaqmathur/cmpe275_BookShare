package edu.sjsu.cmpe275.prj.dao;

import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.Login;



/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPALoginDAO implements LoginDAO{

	public int validate(Login login) {
		
		System.out.println("in Login jpa");
		int loginId= 0;
		try {
			DBCrud<Login> db = new DBCrud<Login>();
			loginId = db.validate(login);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return loginId;
	}

	
}
