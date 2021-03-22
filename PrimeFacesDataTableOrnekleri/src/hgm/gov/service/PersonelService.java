package hgm.gov.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import hgm.gov.dao.PersonelDAO;
import hgm.gov.entities.Personel;

@Named
public class PersonelService {
	@Inject
	private PersonelDAO personelDAO;

	public List<Personel> getPersoneller() {
		return personelDAO.getPersoneller();
	}
}
