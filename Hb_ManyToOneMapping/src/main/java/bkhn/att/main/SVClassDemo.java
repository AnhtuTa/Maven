package bkhn.att.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bkhn.att.hibernate.HibernateUtils;
import bkhn.att.pojo.SVClass;

public class SVClassDemo {
	private SessionFactory factory;
	
	public SVClassDemo() {
		factory = HibernateUtils.getSessionFactory();
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
	
	public String addSVClass(SVClass svc) {
		Session ss = factory.openSession();
		Transaction ts = null;
		
		try {
			ts = ss.beginTransaction();
			String classID = (String) ss.save(svc);
			ts.commit();
			return classID;
		} catch (Exception e) {
			e.printStackTrace();
			if(ts != null) ts.rollback();
		} finally {
			ss.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		SVClassDemo svcd = new SVClassDemo();
		String kq = svcd.addSVClass(new SVClass("cntt2.02k58", "CNTT2.02 - K58", "CNTT"));
		System.out.println("kq = Id cua lop vua duoc them vao DB = " + kq);
		
		
	}
}
