package bkhn.att.main;

import java.util.List;

import org.hibernate.HibernateException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bkhn.att.hibernate.HibernateUtils;
import bkhn.att.pojo.SVClass;
import bkhn.att.pojo.Student;

public class StudentDemo {
	private SessionFactory factory;

	public static void main(String[] args) {
		StudentDemo sd = new StudentDemo();
		sd.factory = HibernateUtils.getSessionFactory();
		sd.showStudents();
		
		//Error will occur!
//		System.out.println("Show Student after closing Session");
//		sd.showStudentsAfterCloseSession();
		
		SVClass svc = sd.getSVClass("cntt2.01k58");
		int kq = sd.addStudent(new Student(20131101, "Songoku", svc));
		System.out.println("kq = " + kq);
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
				System.out.println("\tClass's ID = " + svc.getId());
				System.out.println("\tClass's name = " + svc.getName());
				System.out.println("\tFaculty = " + svc.getFaculty());
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

	public int addStudent(Student st) {
		Session session = factory.openSession();
		Transaction ts = null;
		int resultID = -1;
		
		try {
			ts = session.beginTransaction();
			resultID = (Integer) session.save(st);
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
	
	@SuppressWarnings("unchecked")
	public SVClass getSVClass(String id) {
		Session session = factory.openSession();
		Transaction ts = null;
		SVClass svc;

		try {
			ts = session.beginTransaction();
			String hql = "FROM SVClass where id = :classID";
			Query query = session.createQuery(hql);
			query.setParameter("classID", id);
			List<SVClass> clList = query.getResultList();
			svc = clList.get(0);
			ts.commit();
			return svc;
		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
