package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.util.HibernateUtil;
import entities.Personel;

public class PersonelDAO {
	/**
	 * personel metodu açýklamasý
	 * 
	 * @param tcNo parametre tcno açýklamasý
	 * @return dönüþ deðeri için olan açýklama -- (at)deprecated deprecate olan
	 *         metodlar için açýklama
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
