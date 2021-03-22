package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Data;

@Data
@ManagedBean
@SessionScoped
public class ConfimDialog {
	private List<String> isimler;

	public ConfimDialog() {
		ilkHalineGetir();
	}

	public void isimSil() {
		if (isimler.size() > 0) {
			isimler.remove(isimler.size() - 1);
		}
	}

	public void ilkHalineGetir() {
		isimler = new ArrayList<String>();
		isimler.add("Ali");
		isimler.add("Veli");
		isimler.add("Zeynep");
		isimler.add("Kamuran");
		isimler.add("Kamile");
		isimler.add("Dürdane");
		isimler.add("Fýrtýna");
	}
}
