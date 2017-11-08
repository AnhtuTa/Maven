package bkhn.att.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Cmtnd implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 4 thuộc tính sau tương ứng 4 cột trong database
	int studentID;
	String cmtID;
	Date ngayCap;
	String noiCap;
	
	// Do Cmtnd quan hệ 1-1 với Student nên có thêm thuộc tính sau, nó tương ứng với cột student_id trong CSDL		
	Student student;
	
	public Cmtnd() {}

	public Cmtnd(int studentID, String cmtID, Date ngayCap, String noiCap) {
		super();
		this.studentID = studentID;
		this.cmtID = cmtID;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
	}
	
	public Cmtnd(int studentID, String cmtID, Date ngayCap, String noiCap, Student student) {
		super();
		this.studentID = studentID;
		this.cmtID = cmtID;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.student = student;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getCmtID() {
		return cmtID;
	}

	public void setCmtID(String cmtID) {
		this.cmtID = cmtID;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
