package hgm.gov.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.ToString;

/**
 * The persistent class for the personel_yetki database table.
 * 
 */
@Entity
@Table(name = "personel_yetki")
@NamedQuery(name = "PersonelYetki.findAll", query = "SELECT p FROM PersonelYetki p")
@ToString
public class PersonelYetki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// bi-directional many-to-one association to Personel
	@ManyToOne
	@ToString.Exclude
	private Personel personel;

	// bi-directional many-to-one association to Yetki
	@ManyToOne
	private Yetki yetki;

	public PersonelYetki() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Personel getPersonel() {
		return this.personel;
	}

	public void setPersonel(Personel personel) {
		this.personel = personel;
	}

	public Yetki getYetki() {
		return this.yetki;
	}

	public void setYetki(Yetki yetki) {
		this.yetki = yetki;
	}

}