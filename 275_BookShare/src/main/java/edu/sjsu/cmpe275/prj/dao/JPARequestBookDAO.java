package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.dataoperations.DBCrud;

import edu.sjsu.cmpe275.prj.models.requestBook;

public class JPARequestBookDAO implements RequestBookDAO {

	public int insert(requestBook requestbook) {
		
		System.out.println("in category jpa");
		int addressId= 0;
		try {
			DBCrud<requestBook> db = new DBCrud<requestBook>();
			addressId = db.Insert(requestbook);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return addressId;
	}
	



}
