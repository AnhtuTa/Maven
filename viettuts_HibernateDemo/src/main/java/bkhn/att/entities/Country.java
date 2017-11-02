package bkhn.att.entities;

public class Country {
	int id;		//auto increase
	String countryID;	//Mã Quốc gia
	String name;
	String capital;
	
	public Country() {}

	public Country(int id, String countryID, String name, String capital) {
		super();
		this.id = id;
		this.countryID = countryID;
		this.name = name;
		this.capital = capital;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	
}
