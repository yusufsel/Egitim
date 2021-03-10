package dao;

import java.util.List;

import dao.util.HibernateUtil;
import entities.Personel;

public class PersonelDAO {
	public List<Personel> getPersonelListesi() {
		return HibernateUtil.getSession().createQuery("from Personel", Personel.class).getResultList();
	}
}
