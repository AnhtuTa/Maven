package bkhn.att.main;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bkhn.att.hibernate.HibernateUtils;
import bkhn.att.pojo.Cmtnd;
import bkhn.att.pojo.SVClass;
import bkhn.att.pojo.Student;

public class StudentDemo {
	private SessionFactory factory;
	
	public StudentDemo() {
		factory = HibernateUtils.getSessionFactory();
	}

	public static void main(String[] args) {
		StudentDemo sd = new StudentDemo();
		sd.showStudents();
		
		//Error will occur!
//		System.out.println("Show Student after closing Session");
//		sd.showStudentsAfterCloseSession();
		
		SVClass svc = new SVClassDemo().getSVClass("cntt2.01k58"); //sd.getSVClass("cntt2.01k58");
		//int kq = sd.addStudent(new Student(20131103, "Huy ga", svc));
		//System.out.println("ID cua SV vua duoc them vao DB = " + kq);
		
		//boolean kq2 = sd.updateStudent(20131001, "Nguyen Van Anh", svc);
		//System.out.println("kq2 = " + kq2);
		
		//kq2 = sd.deleteStudent(20131101);
		//System.out.println("kq xoa = " + kq2);
		
		//int kq3 = sd.updateStudentHQL(20131001, "Nguyen Van Linh", svc);
		//System.out.println("kq3 = " + kq3);
		
		int kq3 = sd.addStudent(new Student(20131007, "Nguyen Van Trung", svc), new Cmtnd(20131007, "12350", Date.valueOf("2010-01-29"), "Hai Phong"));
		System.out.println("kq3 = " + kq3);
	}

	@SuppressWarnings("unchecked")
	public void showStudents() {
		Session session = factory.openSession();
		Transaction ts = null;

		try {
			ts = session.beginTransaction();
			List<Student> stList = session.createQuery("FROM Student").list();
			for (Student st : stList) {
				System.out.println(st.getInfo());
				
				SVClass svc = st.getSvclass();
				System.out.println("\tClass's ID: " + svc.getId());
				System.out.println("\tClass's name: " + svc.getName());
				System.out.println("\tFaculty: " + svc.getFaculty());
				
				Cmtnd cmt = st.getCmt();
				if(cmt != null) System.out.println("\tSo CMND: " + cmt.getCmtID());
				else System.out.println("\tSo CMND: Khong co");
			}

			ts.commit();
		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	// Lấy thông tin SV sau khi đóng Session
	// => chỉ lấy được tên và mã SV, không lấy được tên lớp
	@SuppressWarnings("unchecked")
	public void showStudentsAfterCloseSession() {
		Session session = factory.openSession();
		Transaction ts = null;
		List<Student> stList = null;

		try {
			ts = session.beginTransaction();
			stList = session.createQuery("FROM Student").list();
			ts.commit();
		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		for (Student st : stList) {
			System.out.println(st.getInfo());
			
			try {
				SVClass svc = st.getSvclass();
				System.out.println("\tClass's ID = " + svc.getId());
				System.out.println("\tClass's name = " + svc.getName());
				System.out.println("\tFaculty = " + svc.getFaculty());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	/*
	 * Chú ý: ko có lệnh:
	 * INSERT INTO Student values(2001200, "My Name", svclass);
	 */
	public int addStudent(Student st) {
		Session session = factory.openSession();
		Transaction ts = null;
		int resultID = -1;
		
		try {
			ts = session.beginTransaction();
			resultID = (Integer) session.save(st);		//Do id của Student là kiểu int nên mới có thể ép kiểu, chú ý là kq trả về là id của thằng đc lưu vào DB chứ ko phải số lượng thằng đc lưu vào DB		
			ts.commit();
		} catch (Exception e) {
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return resultID;
	}
	
	/**
	 * @param st : Phải ko có cmt, sau đó sẽ lấy cmt có giá trị  = tham số cmt
	 */
	public int addStudent(Student st, Cmtnd cmt) {
		Session session = factory.openSession();
		Transaction ts = null;
		int resultID = -1;
		
		try {
			ts = session.beginTransaction();
			resultID = (Integer) session.save(st);		//Do id của Student là kiểu int nên mới có thể ép kiểu, chú ý là kq trả về là id của thằng đc lưu vào DB chứ ko phải số lượng thằng đc lưu vào DB		
			session.save(cmt);		//chú ý rằng cmt ko cần có đủ giá trị các field, chỉ cần có đủ giá trị các field mà có trong bảng. VD: field Student student của nó ko có trong table nên ko cần chỉ rõ ở đây
			ts.commit();
		} catch (Exception e) {
			resultID = -1;
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return resultID;
	}
	
	public boolean updateStudent(int id, String name, SVClass svclass) {
		Session ss = factory.openSession();
		Transaction ts = null;
		
		try {
			 ts = ss.beginTransaction();
			 Student st = ss.get(Student.class, id);		//get student from DB
			 st.setName(name);
			 st.setSvclass(svclass);
			 ss.update(st);				//And update that student. Why we must get a student from DB after update?
			 ts.commit();
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			ss.close();
		}
		return false;
	}

	public int updateStudentHQL(int id, String name, SVClass svclass) {
		Session ss = factory.openSession();
		Transaction ts = null;
		
		try {
			 ts = ss.beginTransaction();
			 String hql = "UPDATE Student set name = :name, svclass = :svclass "  + 
		             	  "WHERE id = :stID";

			 Query query = ss.createQuery(hql);
			 query.setParameter("name", name);
			 query.setParameter("svclass", svclass);
			 query.setParameter("stID", id);
			 
			 int kq = query.executeUpdate();
			 ts.commit();		//ko cần commit vẫn chạy đc, nhưng nếu dùng hàm updateStudent() ở trên thì phải commit!
			 return kq;		//so luong ban ghi dc update
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			ss.close();
		}
		return -1;
	}
	
	public boolean deleteStudent(int id) {
		Session ss = factory.openSession();
		Transaction ts = null;
		
		try {
			 ts = ss.beginTransaction();
			 Student st = ss.get(Student.class, id);
			 ss.delete(st);
			 ts.commit();
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			ss.close();
		}
		return false;
	}
	
	public int deleteStudentHQL(int id) {
		Session ss = factory.openSession();
		Transaction ts = null;
		
		try {
			 ts = ss.beginTransaction();
			 String hql = "DELETE FROM Student "  + 
		             	  "WHERE id = :stID";
			 Query query = ss.createQuery(hql);
			 query.setParameter("stID", id);
			 int kq = query.executeUpdate();
			 ts.commit();
			 return kq;
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		} finally {
			ss.close();
		}
		return -1;
	}
}
