package hgm.gov.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import hgm.gov.dao.IsimlerDAO;
import hgm.gov.entities.Isimler;

@Named
public class IsimlerService {
	@Inject
	private IsimlerDAO isimlerDAO;

	public List<Isimler> getIsimler() {
		return isimlerDAO.getIsimler();
	}

	public Page<Isimler> getIsimler(int page, int size) {
		return isimlerDAO.getIsimler(page, size);
	}

	public long getKayitSayisi() {
		return isimlerDAO.getKayitSayisi();
	}

}
