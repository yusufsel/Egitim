package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the birlik database table.
 * 
 */
@Entity
@NamedQuery(name = "Birlik.findAll", query = "SELECT b FROM Birlik b")
public class Birlik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String adi;

	private int mevcut;

	private String sehir;

	@OneToMany(mappedBy = "birlik", fetch = FetchType.LAZY)
	private Set<Personel> personeller;

	public Birlik() {
	}

	public Set<Personel> getPersoneller() {
		return personeller;
	}

	public void setPersoneller(Set<Personel> personeller) {
		this.personeller = personeller;
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

	@Override
	public String toString() {
		return "Birlik [id=" + id + ", adi=" + adi + ", mevcut=" + mevcut + ", sehir=" + sehir + "]";
	}

}