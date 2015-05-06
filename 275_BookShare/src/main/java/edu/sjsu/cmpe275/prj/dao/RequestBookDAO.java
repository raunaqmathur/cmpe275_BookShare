package edu.sjsu.cmpe275.prj.dao;

import java.util.List;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface RequestBookDAO {
	
	public int insert(requestbook category);
	
	public List<requestbook> getRequestdetails();

}