package edu.sjsu.cmpe275.prj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;
import edu.sjsu.cmpe275.prj.models.requestbook;

public class JPARequestBookDAO implements RequestBookDAO {

	public int insert(requestbook category) {
		
		System.out.println("in category jpa request making");
		int addressId= 0;
		try {
			DBCrud<requestbook> db = new DBCrud<requestbook>();
			addressId = db.Insert(category);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return addressId;
	}
	
	public List<requestbook> getRequestdetails()
	{
		List<requestbook> temprequestBook = new ArrayList<requestbook>();
		try {
			DBCrud<requestbook> db = new DBCrud<requestbook>();
			temprequestBook=  db.getRequestdetails();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return temprequestBook;
	}

	
	
	}

