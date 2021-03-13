package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.ToString;

/**
 * The persistent class for the personel database table.
 * 
 */
@ToString
@Entity
@NamedQuery(name = "butunPersoneller", query = "from Personel")
@NamedQuery(name = "tekPersonel", query = "from Personel p where p.id = :pid")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String adi;

	private String sifre;

	private String soyadi;

	private String tcno;

	@ManyToOne(fetch = FetchType.LAZY)
	@ToString.Exclude
	private Birlik birlik;

	// bi-directional many-to-one association to PersonelAdre
	@ToString.Exclude
	@OneToMany(mappedBy = "personel", fetch = FetchType.LAZY)
	private Set<PersonelAdres> personelAdres;

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

	public Birlik getBirlik() {
		return birlik;
	}

	public void setBirlik(Birlik birlik) {
		this.birlik = birlik;
	}

	public Set<PersonelAdres> getPersonelAdres() {
		return personelAdres;
	}

	public void setPersonelAdres(Set<PersonelAdres> personelAdres) {
		this.personelAdres = personelAdres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personel other = (Personel) obj;
		if (id != other.id)
			return false;
		return true;
	}

}