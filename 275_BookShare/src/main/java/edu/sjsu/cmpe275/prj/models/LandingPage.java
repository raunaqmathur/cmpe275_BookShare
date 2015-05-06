package edu.sjsu.cmpe275.prj.models;

import java.util.List;

/**
 * This model class contains the properties for the filed on the login.jsp page.
 * @author Ram
 *
 */

public class LandingPage {
	private List<category> categories;
	private List<book> books;
	
	public List<category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<category> categoriesI) {
		categories = categoriesI;
	}
	
	public List<book> getBooks() {
		return books;
	}
	
	public void setBooks(List<book> booksI) {
		books = booksI;
	}
}
