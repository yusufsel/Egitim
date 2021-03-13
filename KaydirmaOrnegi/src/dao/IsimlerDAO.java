package dao;

import java.util.List;

import org.hibernate.query.Query;

import dao.util.HibernateUtil;
import entities.Isimler;

public class IsimlerDAO {
	public List<Isimler> getIsimler(int baslangicKayitSayisi) {
		Query<Isimler> query = HibernateUtil.getSession().createQuery("from Isimler", Isimler.class);
		// sayfalama icin
		query.setFirstResult(baslangicKayitSayisi);
		query.setMaxResults(100);
		return query.getResultList();
	}
}
