package bkhn.att.pojo;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	// 2 thuộc tính sau tương ứng 2 cột trong database
	int id;
	String name;

	// Do Student quan hệ n-1 với SVClass nên có thêm thuộc tính sau, nó tương ứng với cột class_id trong CSDL, dùng trong CSDL, class_id có kiểu VARCHAR	
	SVClass svclass;
	
	// Do Student quan hệ 1-1 với Cmtnd nên có thêm thuộc tính sau, nó chả tương ứng với cột nào trong CSDL
	Cmtnd cmt;
	
	// Do Student quan hệ n-n với Course nên có thêm thuộc tính sau
	Set<Course> courseSet;
	
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

	public Set getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set courseSet) {
		this.courseSet = courseSet;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) return false;
//		if (!this.getClass().equals(obj.getClass())) return false;
//
//		Student obj2 = (Student) obj;
//		if ((this.id == obj2.getId())) {
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public int hashCode() {
//		int tmp = 0;
//		tmp = (id + name).hashCode();
//		return tmp;
//	}
}
