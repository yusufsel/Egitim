package dao;

import org.hibernate.query.Query;

import dao.util.HibernateUtil;
import entities.Personel;

public class PersonelDAO {

	public Personel getPersonel(String tcNo) {
		Query<Personel> query = HibernateUtil.getSession().createQuery("from Personel p where p.tcno = ?", Personel.class);
		query.setParameter(1, tcNo);
		return query.uniqueResult();
	}

}
