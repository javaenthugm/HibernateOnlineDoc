package org.hibernate.tutorial.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

public class Person {
	
	@Column(name="id")
	private Long id;
	
	@Column(name="age")
	private int age;
	private String firstName;
	private String lastName;
	
	@OneToMany(cascade=CascadeType.ALL)	
	private Set<Event> events;	
	
	
	public Person(){}
	
	public Person(String firstname, String lastname, int age){
		this.firstName = firstname;
		this.lastName = lastname;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEvents(Set<Event> events){
		this.events = events;
	}
	
	public Set<Event> getEvents(){
		return events;
	}

	


	
	

	
	
	
}
