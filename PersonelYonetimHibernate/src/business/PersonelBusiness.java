package business;

import java.util.List;

import beans.Personel;
import db.PersonelDB;
import exceptions.business.BusinessException;
import exceptions.db.CRUDException;
import util.Sabitler;

public class PersonelBusiness {
	public List<Personel> getPersoneller() throws BusinessException {
		try {
			return new PersonelDB().getPersonelListesi();
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_PERSONEL_OKUNAMADI, e);
		}
	}

	public void personelResimGuncelle(int id, byte[] resim) throws BusinessException {
		try {
			PersonelDB personelDb = new PersonelDB();
			Personel personel = personelDb.getPersonel(id);
			personel.setResim(resim);
			personelDb.personelGuncelle(personel);
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_PERSONEL_GUNCELLENEMEDI, e);
		}
	}

	public Personel getPersonel(int id) throws BusinessException {
		try {
			return new PersonelDB().getPersonel(id);
		} catch (CRUDException e) {
			throw new BusinessException(Sabitler.HATA_PERSONEL_OKUNAMADI, e);
		}
	}
}
