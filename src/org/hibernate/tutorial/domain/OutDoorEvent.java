package org.hibernate.tutorial.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity @Table(name="out_door_events")
@PrimaryKeyJoinColumn(name="EVENTS")
public class OutDoorEvent extends Event{
	
	private String evtName;

	public String getEvtName() {
		return evtName;
	}

	public void setEvtName(String evtName) {
		this.evtName = evtName;
	}
	
	

}
