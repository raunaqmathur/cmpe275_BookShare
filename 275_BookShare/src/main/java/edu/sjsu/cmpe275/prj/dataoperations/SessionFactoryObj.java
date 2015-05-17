package edu.sjsu.cmpe275.prj.dataoperations;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryObj {
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory(){
		return new AnnotationConfiguration().configure().buildSessionFactory();
		//return new AnnotationConfiguration().configure(configFile)
	}
}
