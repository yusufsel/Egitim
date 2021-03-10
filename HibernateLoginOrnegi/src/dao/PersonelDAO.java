package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.util.HibernateUtil;
import entities.Personel;

public class PersonelDAO {
	/**
	 * personel metodu a��klamas�
	 * 
	 * @param tcNo parametre tcno a��klamas�
	 * @return d�n�� de�eri i�in olan a��klama -- (at)deprecated deprecate olan
	 *         metodlar i�in a��klama
	 */
	public Personel getPersonel(String tcNo) {
		Query<Personel> query = HibernateUtil.getSession().createQuery("from Personel p where p.tcno = ?1", Personel.class);
		query.setParameter(1, tcNo);
		return query.uniqueResult();
	}

	public void personelYarat(Personel personel) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(personel);
		session.getTransaction().commit();
	}

}
