package org.hibernate.tutorial.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

class TestAnotherMain{
	public static void main(String args[]){
		System.out.println("Another Main");
	}
}

public class HibernateEventManager {
	
	public static void main(String args[]){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println(sdf.format(new Date()));
		
		HibernateEventManager mgr = new HibernateEventManager();
		
		Person p1 = new Person();
		p1.setFirstName("Gopi");
		p1.setLastName("M2");
		p1.setAge(40);
		
		Event e1 = new Event();
		e1.setEvtName("Event-1");
		
		Event e2 = new Event();
		e2.setEvtName("Event-2");
		
		Set<Event> events = new HashSet<>();
		events.add(e1);
		events.add(e2);
		
		p1.setEvents(events);
		
		
		Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.persist(p1);
		
		session.getTransaction().commit();
		
		
		
		HibernateUtil.getSessionFactory().close();
	}
	
	private Person createAndStorePerson(String firstname,String lastname, int age){
		
		Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person p = new Person(firstname, lastname, age);
		
		session.save(p);
		session.getTransaction().commit();
						
		return p;
		
	}
	
	private Event createAndStoreEvent(String title,Date date){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Event event = new Event();
		
		event.setTitle(title);
		event.setDate(date);
		
		event.setEvtName("changing static test");
		//event.setTrans("Transient");

		session.save(event);
		
		
		
		session.getTransaction().commit();
		
		return event;
		
	}
/*	
	private void addPersonToEvent(long personId,long eventId){
		Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person  p = (Person)session.load(Person.class, personId);
		Event e = (Event) session.load(Event.class,eventId);
		
		//p.getEvents().add(e);
		p.addToEvent(e);
		session.getTransaction().commit();
		
	}*/
	/*
	private void addEmailToPerson(long personid,String email){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Person p  = (Person) session.load(Person.class, personid);
		
		p.getEmailAddress().add(email);
		
		session.getTransaction().commit();
		
	}*/
	
	/*private List<Event> listEvents(){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<Event> result = session.createQuery("from Event").list();
		
		for(Event e:result){
			System.out.println(e.getId()+":"+e.getTitle()+":"+new java.sql.Date(e.getDate().getTime()));
			Set<Person> people = e.getParticipants();
			for(Person p:people){
				System.out.println("\t:"+p.getFirstName());
			}
		}
		
		session.getTransaction().commit();
		return result;
	}*/
	
	/*private List<Person> listPerson(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query q = session.createQuery("from Person order by id desc");
				q.setFirstResult(1);
				q.setMaxResults(10);
		List<Person> lp = q.list();
		
		
		for(Person p:lp){
			System.out.println(p.getFirstName()+":"+p.getLastName()+":"+p.getAge()+"Id->"+p.getId()+":Age->"+p.getAge()+",Formula Test->"+p.getEmpIdAge());
			Set<Event> le = p.getEvents();
			for(Event e: le){
				System.out.println("\t"+e.getId()+":"+e.getTitle()+":"+new java.sql.Date(e.getDate().getTime())+":"+e.getEvtName());
			}
		}
		
		
		session.getTransaction().commit();
		return lp;
		
	}*/

}
