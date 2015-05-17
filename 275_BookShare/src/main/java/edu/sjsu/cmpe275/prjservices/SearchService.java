package edu.sjsu.cmpe275.prjservices;

import java.util.List;

import edu.sjsu.cmpe275.prj.models.internalCategory;
import edu.sjsu.cmpe275.prj.models.book;
import edu.sjsu.cmpe275.prj.models.category;

/**
 * SearchService Interface
 * @author Karan
 *
 */
@SuppressWarnings("unused")
public interface SearchService {
 
	public List<book> getAllResults(String input);
	public List<book> getResultsByCategory(List<category> cInput);
	public List<book> getResultsByName(String input);
	public List<category> getCategoriesByBookJonCateg();
	public List<book> doAdvanceSearch(String auth, double priceLow, double priceHigh, String [] condition, int [] categories);
}