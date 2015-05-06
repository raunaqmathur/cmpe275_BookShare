package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface CategoryDAO {
	public int insert(category category);
	
	
	public void delete(category category);
	
	public void update(category category);
	
	
	public category getCategory(int categoryId);
	
}
