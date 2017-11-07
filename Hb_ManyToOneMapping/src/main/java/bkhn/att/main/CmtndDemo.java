package bkhn.att.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bkhn.att.hibernate.HibernateUtils;
import bkhn.att.pojo.Cmtnd;


public class CmtndDemo {
	private SessionFactory factory;
	
	public CmtndDemo() {
		factory = HibernateUtils.getSessionFactory();
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
}
