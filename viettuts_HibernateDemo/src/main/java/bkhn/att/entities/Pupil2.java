package bkhn.att.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Dùng annotation để mapping với table trong database

@Entity
@Table(name="pupil")
public class Pupil2 {
	private int id;		//auto increase
	
	private String name;
	
	private String addr;
	
	private String countryID;
	
	public Pupil2() {}

	public Pupil2(int id, String name, String addr, String countryID) {
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.countryID = countryID;
	}
	

	public Pupil2(String name, String addr, String countryID) {
		this.name = name;
		this.addr = addr;
		this.countryID = countryID;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="addr")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name="countryID")
	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	
	public String getInfo() {
		return this.id + " - " + this.name + " - " + this.addr + " - " + this.countryID;
	}
}
