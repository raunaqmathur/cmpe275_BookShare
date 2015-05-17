package edu.sjsu.cmpe275.prjservices;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 


import edu.sjsu.cmpe275.prj.models.internalCategory;
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.category;
import edu.sjsu.cmpe275.prj.dao.JPABookDAO;
import edu.sjsu.cmpe275.prj.dao.JPARequestCategory;
import edu.sjsu.cmpe275.prj.dao.UserDAO;

/**
 * Implementation of UserRecordService
 * @author karan
 *
 */
@SuppressWarnings("unused")
@Service("searchService")
public class SearchServiceImpl implements SearchService {
    
    private JPABookDAO bookDAO = new JPABookDAO();
    private JPARequestCategory catDAO = new JPARequestCategory();

	public List<book> getAllResults(String input) {
		
		return bookDAO.getAllResults(input);
	}

	public List<book> getResultsByCategory(List<category> cInput) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<book> getResultsByName(String input) {
		
		return bookDAO.getResultsByName(input);
	}

	public List<book> doAdvanceSearch(String auth, double priceLow, double priceHigh,
			String [] condition, int[] categories) {
		return bookDAO.doAdvanceSearch(auth, priceLow, priceHigh, condition, categories);
		
	}
	
	public List<category> getCategoriesByBookJonCateg() 
	{
		return catDAO.getCategoriesByBookJonCateg();
	}
 
    

}