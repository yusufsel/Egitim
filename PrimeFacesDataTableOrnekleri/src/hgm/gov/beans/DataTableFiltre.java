package hgm.gov.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hgm.gov.entities.Personel;
import hgm.gov.service.PersonelService;

@Named
@ManagedBean
@SessionScoped
public class DataTableFiltre {
	private List<Personel> liste;
	private List<Personel> listeFiltreli;
	@Inject
	private PersonelService personelService;

	public List<Personel> getListe() {
		if (liste == null || liste.isEmpty()) {
			liste = personelService.getPersoneller();
		}
		return liste;
	}

	public void setListe(List<Personel> liste) {
		this.liste = liste;
	}

	public List<Personel> getListeFiltreli() {
		return listeFiltreli;
	}

	public void setListeFiltreli(List<Personel> listeFiltreli) {
		this.listeFiltreli = listeFiltreli;
	}

}
