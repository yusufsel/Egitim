package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.Data;

@Data
@ManagedBean
public class Growl {
	private String isim;

	public void kontrol() {
		if ("".equals(isim)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Hata", "Ýsim boþ geçilemez"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ýþlem Baþarýlý", "Baþarýlý bir þekilde giriþ yaptýnýz"));
		}
	}
}
