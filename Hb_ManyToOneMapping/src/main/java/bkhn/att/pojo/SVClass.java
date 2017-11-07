package bkhn.att.pojo;

public class SVClass {
	String id;
	String name;
	String faculty;
	
	public SVClass() {}
	
	public SVClass(String id, String name, String faculty) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = faculty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
}
