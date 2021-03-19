package hgm.gov.beans;

import javax.faces.bean.ManagedBean;

import lombok.Data;

@Data
@ManagedBean
public class CheckBoxOrnek {
	private boolean chk1;
	private String[] chk2 = { "", "", "" };

	public String getChk2Oku() {
		StringBuffer sonuc = new StringBuffer();
		for (String s : chk2) {
			sonuc.append(s);
			sonuc.append(",");
		}
		return sonuc.toString();
	}

	public void oku() {

	}
}
