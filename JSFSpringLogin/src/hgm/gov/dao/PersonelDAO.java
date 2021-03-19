package hgm.gov.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import hgm.gov.entities.Personel;
import hgm.gov.repositories.PersonelRepository;

@Named
public class PersonelDAO {
	@Inject
	private PersonelRepository personelRepository;

	public List<Personel> getPersoneller() {
		return personelRepository.findAll();
	}

	public Personel getPersonelByTcno(String tcNo) {
		return personelRepository.findByTcNo(tcNo);
	}
}
