package bkhn.att.pojo;

public class Course {
	String id;
	String subjectID;
	String time;
	
	//Có thể có thêm 1 thuộc tính là studentSet nữa vì Class này quan hệ n-n với Student. Nhưng ko cần
	
	public Course() {}
	
	public Course(String id, String subjectID, String time) {
		super();
		this.id = id;
		this.subjectID = subjectID;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
