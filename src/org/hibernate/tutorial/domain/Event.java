package org.hibernate.tutorial.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="EVENTS")
public class Event implements Serializable{
	@Id 
	@GeneratedValue
	private Long id;
	private String title;
	private Date date;
	private String evtName;

	public Event(){
		
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	public String getEvtName() {
		return evtName;
	}

	public void setEvtName(String evtName) {
		evtName = evtName;
	}

/*	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}*/
	
	
	
	

}
