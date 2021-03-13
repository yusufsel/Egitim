package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.util.HibernateUtil;
import entities.PersonelAdres;

public class PersonelAdresDAO {
	public List<PersonelAdres> getPersonelAdresler(int personelId) {
		Session session = HibernateUtil.getSession();
		// HQL kullan�larak sorgu yap�l�yor
		Query<PersonelAdres> query = session.createQuery("from PersonelAdres p where p.personel.id = :personelId", PersonelAdres.class);
		query.setParameter("personelId", personelId);
		return query.getResultList();

		// NamedQuery kullan�larak sorgu yap�l�yor
//		Query<PersonelAdres> query = session.createNamedQuery("tekAdres", PersonelAdres.class);
//		query.setParameter("personelId", personelId);
//		return query.getResultList();

		// Criteria API kullan�larak sorgu yap�l�yor
//		Criteria criteria = session.createCriteria(PersonelAdres.class);
//		criteria.add(Restrictions.eq("personel.id", personelId));
//		return criteria.list();
	}
}
