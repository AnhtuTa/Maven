package bkhn.att.pojo;

import java.util.Set;

public class SVClass {
	// 3 thuộc tính này tương ứng 3 cột trong CSDL
	String id;
	String name;
	String faculty;
	
	// Do quan hệ 1-n với Student nên có thể thêm thuộc tính sau
	Set<Student> stSet;	// = new HashSet<Student>();
	
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

	public Set<Student> getStSet() {
		return stSet;
	}

	public void setStSet(Set<Student> stSet) {
		this.stSet = stSet;
	}
	
	public String getInfo() {
		return this.getId() + " - " + this.getName() + " - " + this.getFaculty();
	}
}
