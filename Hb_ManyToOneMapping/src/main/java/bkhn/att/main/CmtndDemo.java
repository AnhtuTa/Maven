package bkhn.att.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bkhn.att.hibernate.HibernateUtils;
import bkhn.att.pojo.Cmtnd;
import bkhn.att.pojo.Student;


public class CmtndDemo {
	private SessionFactory factory;
	
	public CmtndDemo() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	public void showCmtnd() {
		Session ss = factory.openSession();
		Transaction ts = null;
		
		try {
			ts = ss.beginTransaction();
			List<Cmtnd> cmtList = ss.createQuery("FROM Cmtnd").list();
			for(Cmtnd cmt : cmtList) {
				System.out.println(cmt.getCmtID());
				System.out.println(cmt.getStudentID());
				Student st = cmt.getStudent();
				System.out.println("\t" + st.getInfo());
			}
		} catch (HibernateException e) {
			if (ts != null) ts.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Cmtnd getCmtnd(String id) {
		Session session = factory.openSession();
		Transaction ts = null;
		Cmtnd cmt;

		try {
			ts = session.beginTransaction();
			String hql = "FROM Cmtnd where id = :cmtID";
			Query query = session.createQuery(hql);
			query.setParameter("cmtID", id);
			List<Cmtnd> cmtList = query.getResultList();
			cmt = cmtList.get(0);
			ts.commit();
			return cmt;
		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		CmtndDemo cd = new CmtndDemo();
		cd.showCmtnd();
	}
}
