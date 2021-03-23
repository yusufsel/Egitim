package hgm.gov.beans;

import java.util.ArrayList;
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
public class DataTableSatirEkleme {
	private List<Isimler> liste;
	@Inject
	private IsimlerService isimlerService;

	public List<Isimler> getListe() {
		if (liste == null) {
			liste = new ArrayList<Isimler>();
			isimlerService.getIsimler(0, 5).toList().forEach(liste::add);
		}
		return liste;
	}

	public void ekKayitlar() {
		isimlerService.getIsimler(liste.size() / 5, 5).toList().forEach(liste::add);
	}

	public void setListe(List<Isimler> liste) {
		this.liste = liste;
	}

}
