package hgm.gov.model;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.springframework.data.domain.Page;

import hgm.gov.entities.Isimler;
import hgm.gov.service.IsimlerService;

public class IsimlerLazyDataModel extends LazyDataModel<Isimler> {
	private static final long serialVersionUID = -7260477503976341804L;
	private IsimlerService isimlerService;
	private Page<Isimler> page;

	public IsimlerLazyDataModel(IsimlerService isimlerService) {
		this.isimlerService = isimlerService;
	}

	@Override
	public int getRowCount() {
		if (page != null) {
			return (int) page.getTotalElements();
		}
		return (int) isimlerService.getKayitSayisi();
	}

	@Override
	public List<Isimler> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
		System.out.println("First: " + first + ", pageSize:" + pageSize);
		page = isimlerService.getIsimler(first / pageSize, pageSize);
		return page.toList();
	}

}
