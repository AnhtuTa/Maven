package bkhn.att.pojo;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int id;
	String name;
	SVClass svclass;
	Cmtnd cmt;
	
	public Student() {}
	
	public Student(int id, String name, SVClass cl) {
		super();
		this.id = id;
		this.name = name;
		this.svclass = cl;
	}

	public Student(int id, String name, SVClass svclass, Cmtnd cmt) {
		super();
		this.id = id;
		this.name = name;
		this.svclass = svclass;
		this.cmt = cmt;
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

	public Cmtnd getCmt() {
		return cmt;
	}

	public void setCmt(Cmtnd cmt) {
		this.cmt = cmt;
	}
}
