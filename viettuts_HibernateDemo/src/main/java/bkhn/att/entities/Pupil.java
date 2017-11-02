package bkhn.att.entities;

public class Pupil {
	int id;		//auto increase
	String name;
	String addr;
	String countryID;
	
	public Pupil() {}

	public Pupil(int id, String name, String addr, String countryID) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.countryID = countryID;
	}

	public Pupil(String name, String addr, String countryID) {
		super();
		this.name = name;
		this.addr = addr;
		this.countryID = countryID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

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
