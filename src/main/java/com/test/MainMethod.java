package com.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class MainMethod {
@SuppressWarnings("deprecation")
public static void main(String[] args) {
	Configuration configuration=new Configuration();
	configuration.configure("hibernate.cfg.xml");
	
	SessionFactory sessionFactory=configuration.buildSessionFactory();
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Student");
	query.setCacheable(true);//to activate the query
	@SuppressWarnings("unchecked")
	List<Student> students=query.list();
	
Iterator<Student>	itr=students.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next().getFirstName());
		System.out.println(itr.next().getLastName());
		//System.out.println(itr.next().getCity());
		System.out.println(itr.next().getMobile());
	}
	
	
	
}
}
