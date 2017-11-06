package bkhn.att.viettuts_HibernateDemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import bkhn.att.entities.Pupil;
import bkhn.att.hibernate.HibernateUtils;

/**
 * 
 * @author anhtu
 *	most simple example:
 *	Criteria cr = session.createCriteria(Employee.class);
 *	List results = cr.list();
 */

public class CriteriaDemo {
	private static SessionFactory factory;
	private static Session session;
	
	
	public static void main(String[] args) {
		try {
			factory = HibernateUtils.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
		session = factory.openSession();
		Transaction tx = null;
		List<Pupil> kq;

		try{
	          tx = session.beginTransaction();
	          Criteria cr = session.createCriteria(Pupil.class);
	 
	          cr.add(Restrictions.eq("id", 5));
	          kq = cr.list();
	          System.out.println("pupil 5th: " + kq.get(0).getName());
	          
	          cr.add(Restrictions.between("id", 2, 10));
	          kq = cr.list();
	          System.out.println("size = " + kq.size());
	          for(Pupil p : kq) {
	        	  System.out.println(p.getInfo());
	          }
	          
	          // To get total row count.
	          cr.setProjection(Projections.rowCount());
	          List rowCount = cr.list();
	 
	          System.out.println("Total Coint: " + rowCount.get(0) );
	          
	          cr.setProjection(Projections.sum("id"));
	          rowCount = cr.list();
	          System.out.println("Total id (tinh tong cua tat ca cac id trong table): " + rowCount.get(0));

	          tx.commit();
	       }catch (HibernateException e) {
	          if (tx!=null) tx.rollback();
	          e.printStackTrace(); 
	       }finally {
	          session.close(); 
	       }

		
		session.close();
	}

}
