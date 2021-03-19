package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Data;

@ManagedBean
@Data
@SessionScoped
public class Giris {
	private String adi;
	private String sifre;

	public Giris() {
		adi = "Ayþe";
	}

	public String girisYap() {
		if (adi.equals(sifre)) {
			return "success";
		} else {
			return null;
		}
	}

	public String isimDegistir() {
		adi = "Mehmet";
		return null;
	}
}
