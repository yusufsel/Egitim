package business;

import java.util.List;

import beans.PersonelAdres;
import db.PersonelAdresDB;
import exceptions.business.BusinessException;
import exceptions.db.CRUDException;
import util.Sabitler;

public class PersonelAdresBusiness {
	public List<PersonelAdres> getPersonelAdresler(int personelId) throws BusinessException {
		try {
			return new PersonelAdresDB().getPersonelAdresler(personelId);
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_OKUNAMADI, e, "Adresler");
		}
	}

	public PersonelAdres getPersonelAdres(int personelAdresId) throws BusinessException {
		try {
			return new PersonelAdresDB().getPersonelAdres(personelAdresId);
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_OKUNAMADI, e, "Personel Adres");
		}
	}

	public void personelAdresSil(int personelAdresId) throws BusinessException {
		try {
			new PersonelAdresDB().personelAdresSil(personelAdresId);
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_SILINEMEDI, e, "Adresler");
		}
	}

	public void personelAdresEkle(PersonelAdres personelAdres) throws BusinessException {
		try {
			new PersonelAdresDB().personelAdresEkle(personelAdres);
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_EKLENEMEDI, e, "Adresler");
		}
	}

	public void personelAdresGuncelle(int personelAdresId, PersonelAdres personelAdres) throws BusinessException {
		try {
			new PersonelAdresDB().personelAdresGuncelle(personelAdresId, personelAdres);
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_GUNCELLENEMEDI, e, "Adresler");
		}
	}

}
