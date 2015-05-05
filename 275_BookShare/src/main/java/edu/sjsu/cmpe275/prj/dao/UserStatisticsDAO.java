package edu.sjsu.cmpe275.prj.dao;

import edu.sjsu.cmpe275.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface UserStatisticsDAO {
	public int insert(UserStatistics userStatistics);
	
	
	public void delete(UserStatistics userStatistics);
	
	public void update(UserStatistics userStatistics);
	
	
	public UserStatistics getUserStatistics(int usId);
	public UserStatistics getUserStatisticsByUser(int userId);
	
}
