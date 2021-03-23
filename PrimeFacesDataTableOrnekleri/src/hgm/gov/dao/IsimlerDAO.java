package hgm.gov.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import hgm.gov.entities.Isimler;
import hgm.gov.repositories.IsimlerRepository;

@Named
public class IsimlerDAO {
	@Inject
	private IsimlerRepository isimlerRepository;

	public Page<Isimler> getIsimler(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Isimler> liste = isimlerRepository.findAll(pageable);
		return liste;
	}

	public List<Isimler> getIsimler() {
		List<Isimler> liste = isimlerRepository.findAll();
		return liste;
	}

	public long getKayitSayisi() {
		return isimlerRepository.count();
	}

}
