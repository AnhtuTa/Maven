package bkhn.att.viettuts_HibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bkhn.att.entities.Pupil;
import bkhn.att.hibernate.HibernateUtils;


public class ManagePupil {
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		try {
            //factory = new Configuration().configure().buildSessionFactory();
			factory = HibernateUtils.getSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

		ManagePupil mp = new ManagePupil();
		mp.showPupils();
		
		System.out.println("\nAdd a Pupil");
		int kqID = mp.addPupil("Son Go Han", "Namek", "JP");
		System.out.println("Id của thằng pupil vừa thêm vào = " + kqID);
		mp.showPupils();
		
		System.out.println("\nUpdate info cho thằng vừa thêm vào:");
		mp.updatePupil(kqID, "Go Han", "Saiyan", "VN");
		mp.showPupils();
		
		System.out.println("\nDelete thằng pupil vừa thêm vào:");
		mp.deletePupil(kqID);
		mp.showPupils();
	}
	
	@SuppressWarnings("unchecked")
	private void showPupils() {
		Session session = factory.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			String sql = "from Pupil p";
			//Chú ý: from Pupil nhé, ko phải from pupil. Với Pupil là tên của entity, ko phải tên của table trong CSDL
			List<Pupil> pupilList = session.createQuery(sql).getResultList();
			for(Pupil p : pupilList) {
				System.out.println(p.getInfo());
			}
			
			//CHÚ Ý NỮA: Nếu SD: select p.id, p.name, p.addr, p.country from Pupil p thì ko thể cast kq về kiểu Pupil đc
		} catch (Exception e) {
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
				
	}

	private int addPupil(String name, String addr, String countryID) {
		Session session = factory.openSession();
		Transaction ts = null;
		int resultID = -1;
		try {
			ts = session.beginTransaction();
			Pupil p = new Pupil(name, addr, countryID);
			resultID = (Integer) session.save(p);
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
	
	private void updatePupil(int pupilID, String name, String addr, String countryID) {
		Session session = factory.openSession();
		Transaction ts = null;
		
		try {
			ts = session.beginTransaction();
			Pupil p = session.get(Pupil.class, pupilID);
			p.setName(name);
			p.setAddr(addr);
			p.setCountryID(countryID);
			session.update(p);
			ts.commit();
		} catch (Exception e) {
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	private void deletePupil(int pupilID) {
		Session session = factory.openSession();
		Transaction ts = null;
		
		try {
			ts = session.beginTransaction();
			Pupil p = session.get(Pupil.class, pupilID);
			session.delete(p);
			ts.commit();
		} catch (Exception e) {
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
