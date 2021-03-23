package hgm.gov.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hgm.gov.entities.Isimler;
import hgm.gov.service.IsimlerService;

@Named
@ManagedBean
@SessionScoped
public class DataTablePaging {
	private List<Isimler> liste;
	@Inject
	private IsimlerService isimlerService;

	public List<Isimler> getListe() {
		if (liste == null) {
			liste = isimlerService.getIsimler();
		}
		return liste;
	}

	public void setListe(List<Isimler> liste) {
		this.liste = liste;
	}

}
