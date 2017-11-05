package bkhn.att.viettuts_HibernateDemo;

import java.util.List;
 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bkhn.att.entities.Pupil2;
import bkhn.att.hibernate.HibernateUtils;

public class ManagePupil2 {
	private static SessionFactory factory;
	
	public void addPupil() {
		
	}
	
	@SuppressWarnings("unchecked")
	private void showPupils() {
		Session session = factory.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			//String sql = "from bkhn.att.entities.Pupil2";
			String sql = "Select p from " + Pupil2.class.getName() + " p";

			List<Pupil2> pupilList = session.createQuery(sql).getResultList();
			for(Pupil2 p : pupilList) {
				System.out.println(p.getInfo());
			}
			
			//CHÚ Ý NỮA: Nếu SD: select p.id, p.name, p.addr, p.country from Pupil p thì ko thể cast kq về kiểu Pupil đc
		} catch (HibernateException e) {
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("done!");
	}
	public static void main(String[] args) {
		factory = HibernateUtils.getSessionFactory();
		
		ManagePupil2 mp = new ManagePupil2();
		mp.showPupils();
	}

}
