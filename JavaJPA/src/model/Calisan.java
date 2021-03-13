package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calisan database table.
 * 
 */
@Entity
@NamedQuery(name="Calisan.findAll", query="SELECT c FROM Calisan c")
public class Calisan implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CalisanPK id;

	private String adi;

	public Calisan() {
	}

	public CalisanPK getId() {
		return this.id;
	}

	public void setId(CalisanPK id) {
		this.id = id;
	}

	public String getAdi() {
		return this.adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

}