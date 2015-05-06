package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface BookDAO {
	public int insert(book category);
	
	
	public void delete(book category);
	
	public void update(book category);
	
	
	public book getBook(int bookId);
	
	
}
