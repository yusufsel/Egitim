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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Hata", "�sim bo� ge�ilemez"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "��lem Ba�ar�l�", "Ba�ar�l� bir �ekilde giri� yapt�n�z"));
		}
	}
}
