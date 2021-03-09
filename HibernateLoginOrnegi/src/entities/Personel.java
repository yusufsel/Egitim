package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the personel database table.
 * 
 */
@Entity
@NamedQuery(name = "Personel.findAll", query = "SELECT p FROM Personel p")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "tcno"))
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String adi;

	private String sifre;

	private String soyadi;

	private String tcno;

	// bi-directional many-to-one association to PersonelAdre
	@OneToMany(mappedBy = "personel")
	private List<PersonelAdre> personelAdres;

	public Personel() {
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

	public String getSifre() {
		return this.sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getSoyadi() {
		return this.soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getTcno() {
		return this.tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public List<PersonelAdre> getPersonelAdres() {
		return this.personelAdres;
	}

	public void setPersonelAdres(List<PersonelAdre> personelAdres) {
		this.personelAdres = personelAdres;
	}

	public PersonelAdre addPersonelAdre(PersonelAdre personelAdre) {
		getPersonelAdres().add(personelAdre);
		personelAdre.setPersonel(this);

		return personelAdre;
	}

	public PersonelAdre removePersonelAdre(PersonelAdre personelAdre) {
		getPersonelAdres().remove(personelAdre);
		personelAdre.setPersonel(null);

		return personelAdre;
	}

}