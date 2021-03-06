package bkhn.att.viettuts_HibernateDemo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bkhn.att.entities.Pupil;
import bkhn.att.hibernate.HibernateUtils;

public class HQLDemo {
	private static SessionFactory factory;
	private static Session session;
	
	
	@SuppressWarnings("unchecked")
	public void showResult(String hql) {
		Query query;
		List<Pupil> pupilList;
		
		//==========================
		query = session.createQuery(hql);
		pupilList = query.getResultList();
		for(Pupil p : pupilList) {
			System.out.println(p.getInfo());
		}
		System.out.println("====================");
	}
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			factory = HibernateUtils.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
		session = factory.openSession();
		
		String hql;
		HQLDemo demo = new HQLDemo();
		
		hql = "FROM Pupil";
		demo.showResult(hql);
		
		hql = "FROM Pupil WHERE id > 5";
		demo.showResult(hql);
		
		hql = "FROM Pupil ORDER BY name";
		demo.showResult(hql);
		
		hql = "FROM Pupil WHERE id > :puID";
		Query query = session.createQuery(hql);
		query.setParameter("puID", 7);
		List<Pupil> pupilList = query.getResultList();
		for(Pupil p : pupilList) {
			System.out.println(p.getInfo());
		}
		System.out.println("====================");
		
		hql = "select count(p.name) from Pupil p";
		query = session.createQuery(hql);
		List<Long> kqList = query.getResultList();
		System.out.println(kqList.size());		//1
		System.out.println(kqList.get(0));		//10
		System.out.println("====================");
		
		session.close();
	}
}
