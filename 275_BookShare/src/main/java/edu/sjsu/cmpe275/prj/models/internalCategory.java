package edu.sjsu.cmpe275.prj.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * This model class contains the properties for the filed on the login.jsp page.
 * @author karan
 *
 */




	
	public class internalCategory {
		
		@SuppressWarnings("unused")
		private static final long serialVersionUID = 1L;
		

public List<internalCategory> cm= new ArrayList<internalCategory>();

		
	    private int category_Id = 5;
	    
	    private int [] slist;
	    
	    private String name;
	    
		private int selected;
	    
	    private int active;


		public int getCategoryId() {
			return category_Id;
		}


		public void setCategoryId(int categoryId) {
			this.category_Id = categoryId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getActive() {
			return active;
		}

		public int getSelected()
		{
			return selected;
		}

		public void setSelected(int selected) {
			this.selected = selected;
		}


		public List<internalCategory> getCm() {
			return cm;
		}


		public void setCm(List<internalCategory> cm) {
			this.cm = cm;
		}
		
public List<internalCategory> change(List<category> Cat)
{
	for (category categi : Cat) {
		internalCategory ic = new internalCategory();
		ic.active=categi.getActive();
		ic.category_Id=categi.getCategoryId();
		ic.name=categi.getName();
		ic.selected=0;
		cm.add(ic);
				
	}
	return cm;
	}


public int[] getSlist() {
	return slist;
}


public void setSlist(int[] slist) {
	this.slist = slist;
}

		
	}

	
