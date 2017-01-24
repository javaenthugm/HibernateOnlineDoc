package org.hibernate.tutorial.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tutorial.domain.Event;

public class ConfigurationTest {
	
	public static void main(String args[]){
		Configuration conf = new Configuration()
			.setProperty("connection.driver_class", "org.hsqldb.jdbcDriver")
			.setProperty("connection.url", "jdbc:hsqldb:hsql://localhost")
			.setProperty("hibernate.dialect","org.hibernate.dialect.HSQLDialect")
			.setProperty("connection.username", "sa")
			.setProperty("connection.password", "")
			.setProperty("current_session_context_class","thread")
			.addClass(org.hibernate.tutorial.domain.Person.class)
		    .addClass(org.hibernate.tutorial.domain.Event.class);
		
		
		SessionFactory sf = conf.buildSessionFactory();
		Session s = sf.getCurrentSession();
		List<Event> l = s.createQuery("from Event").list();

		for(Event e:l)
			System.out.println(e.getTitle());
		
	}

}
