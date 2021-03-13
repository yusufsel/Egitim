package db;

import java.util.List;

import javax.persistence.TypedQuery;

import beans.PersonelAdres;
import exceptions.db.CreateException;
import exceptions.db.DeleteException;
import exceptions.db.ReadException;
import exceptions.db.UpdateException;

public class PersonelAdresDB extends DBBase {
	public List<PersonelAdres> getPersonelAdresler(int personelId) throws ReadException {
		try {
			TypedQuery<PersonelAdres> query = getConnection().createQuery("from PersonelAdres a where a.personel.id = :id", PersonelAdres.class);
			query.setParameter("id", personelId);
			return query.getResultList();
		} catch (Exception e) {
			throw new ReadException("personel_adres", e);
		}
	}

	public PersonelAdres getPersonelAdres(int personelAdresId) throws ReadException {
		try {
			return getConnection().find(PersonelAdres.class, personelAdresId);
		} catch (Exception e) {
			throw new ReadException("personel_adres", e);
		}
	}

	public void personelAdresSil(int personelAdresId) throws DeleteException {
		try {
			PersonelAdres adres = getPersonelAdres(personelAdresId);
			getConnection().getTransaction().begin();
			getConnection().remove(adres);
			getConnection().getTransaction().commit();
		} catch (Exception e) {
			throw new DeleteException("personel_adres", e);
		}
	}

	public void personelAdresEkle(PersonelAdres personelAdres) throws CreateException {
		try {
			getConnection().getTransaction().begin();
			getConnection().persist(personelAdres);
			getConnection().getTransaction().commit();
		} catch (Exception e) {
			throw new CreateException("personel_adres", e);
		}
	}

	public void personelAdresGuncelle(int personelAdresId, PersonelAdres personelAdres) throws UpdateException {
		try {
			PersonelAdres adres = getPersonelAdres(personelAdresId);
			adres.setAdres(personelAdres.getAdres());
			getConnection().getTransaction().begin();
			getConnection().persist(adres);
			getConnection().getTransaction().commit();
		} catch (Exception e) {
			throw new UpdateException("personel_adres", e);
		}
	}
}
