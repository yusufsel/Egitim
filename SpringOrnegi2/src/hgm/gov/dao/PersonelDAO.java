package hgm.gov.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hgm.gov.entities.Personel;
import hgm.gov.repositories.PersonelRepository;

@Component
public class PersonelDAO {
	@Autowired
	private PersonelRepository personelRepository;

	public List<Personel> getPersoneller() {
		return personelRepository.findAll();
	}
}
