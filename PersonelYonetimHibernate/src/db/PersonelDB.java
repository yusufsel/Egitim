package db;

import java.util.List;

import beans.Personel;
import exceptions.db.ReadException;
import exceptions.db.UpdateException;

public class PersonelDB extends DBBase {
	public List<Personel> getPersonelListesi() throws ReadException {
		try {
			return getConnection().createQuery("from Personel", Personel.class).getResultList();
		} catch (Exception e) {
			throw new ReadException("personel", e);
		}
	}

	public Personel getPersonel(int id) throws ReadException {
		try {
			return getConnection().find(Personel.class, id);
		} catch (Exception e) {
			throw new ReadException("personel", e);
		}
	}

	public void personelGuncelle(Personel personel) throws UpdateException {
		try {
			getConnection().getTransaction().begin();
			getConnection().persist(personel);
			getConnection().getTransaction().commit();
		} catch (Exception e) {
			throw new UpdateException("personel", e);
		}
	}
}
