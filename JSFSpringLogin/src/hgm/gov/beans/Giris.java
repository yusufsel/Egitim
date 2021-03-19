package hgm.gov.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import hgm.gov.service.PersonelService;
import lombok.Data;

@Data
@Named
@ManagedBean
public class Giris {
	private String tcNo;
	private String sifre;
	@Inject
	private PersonelService personelService;

	public String girisYap() {
		if (personelService.sifreKontrolu(tcNo, sifre.toCharArray())) {
			// giri� ba�ar�l�
			return "giris_basarili";
		}
		// giri� yap�lamad�
		// ekrana hata mesaj� g�nderilecek
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage mesaj = new FacesMessage("Yanl�� kullan�c� ad� / �ifre");
		facesContext.addMessage(null, mesaj);
		return null;
	}
}
