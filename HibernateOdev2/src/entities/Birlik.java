package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the birlik database table.
 * 
 */
@Entity
@NamedQuery(name="Birlik.findAll", query="SELECT b FROM Birlik b")
public class Birlik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String adi;

	private int mevcut;

	private String sehir;

	public Birlik() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return this.adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public int getMevcut() {
		return this.mevcut;
	}

	public void setMevcut(int mevcut) {
		this.mevcut = mevcut;
	}

	public String getSehir() {
		return this.sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

}