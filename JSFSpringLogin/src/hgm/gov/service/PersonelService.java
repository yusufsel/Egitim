package hgm.gov.service;

import javax.inject.Inject;
import javax.inject.Named;

import hgm.gov.dao.PersonelDAO;
import hgm.gov.entities.Personel;
import hgm.gov.util.Util;

@Named
public class PersonelService {
	@Inject
	private PersonelDAO personelDAO;

	public boolean sifreKontrolu(String tcNo, char[] sifre) {
		Personel personel = personelDAO.getPersonelByTcno(tcNo);
		if (personel != null && Util.getPasswordAuthentication().authenticate(sifre, personel.getSifre())) {
			return true;
		}
		return false;
	}
}
