package bkhn.att.pojo;

public class Student {
	int id;
	String name;
	SVClass svclass;
	
	public Student() {}
	
	public Student(int id, String name, SVClass cl) {
		super();
		this.id = id;
		this.name = name;
		this.svclass = cl;
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

	public SVClass getSvclass() {
		return svclass;
	}

	public void setSvclass(SVClass svclass) {
		this.svclass = svclass;
	}

	public String getInfo() {
		return this.getId() + " - " + this.getName();
	}
}
