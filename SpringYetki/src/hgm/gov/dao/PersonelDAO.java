package hgm.gov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hgm.gov.entities.Personel;
import hgm.gov.repository.PersonelRepository;

@Component
public class PersonelDAO {
	@Autowired
	private PersonelRepository personelRepository;

	public Personel getPersonel(int tcNo) {
		return personelRepository.findByTcno(tcNo);
	}
}
