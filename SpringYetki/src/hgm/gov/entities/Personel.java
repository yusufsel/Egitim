package hgm.gov.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the personel database table.
 * 
 */
@Entity
@NamedQuery(name = "Personel.findAll", query = "SELECT p FROM Personel p")
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String adi;

	@Column(name = "birlik_id")
	private int birlikId;

	@Lob
	private byte[] resim;

	private String sifre;

	private String soyadi;

	private String tcno;

	// bi-directional many-to-one association to PersonelYetki
	@OneToMany(mappedBy = "personel")
	private List<PersonelYetki> personelYetkis;

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

	public int getBirlikId() {
		return this.birlikId;
	}

	public void setBirlikId(int birlikId) {
		this.birlikId = birlikId;
	}

	public byte[] getResim() {
		return this.resim;
	}

	public void setResim(byte[] resim) {
		this.resim = resim;
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

	public List<PersonelYetki> getPersonelYetkis() {
		return this.personelYetkis;
	}

	public void setPersonelYetkis(List<PersonelYetki> personelYetkis) {
		this.personelYetkis = personelYetkis;
	}

	public PersonelYetki addPersonelYetki(PersonelYetki personelYetki) {
		getPersonelYetkis().add(personelYetki);
		personelYetki.setPersonel(this);

		return personelYetki;
	}

	public PersonelYetki removePersonelYetki(PersonelYetki personelYetki) {
		getPersonelYetkis().remove(personelYetki);
		personelYetki.setPersonel(null);

		return personelYetki;
	}

}