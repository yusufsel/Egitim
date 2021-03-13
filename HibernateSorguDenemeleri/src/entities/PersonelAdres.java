package entities;

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
 * The persistent class for the personel_adres database table.
 * 
 */
@Entity
@Table(name = "personel_adres")
@NamedQuery(name = "PersonelAdres.findAll", query = "SELECT p FROM PersonelAdres p")
@NamedQuery(name = "tekAdres", query = "from PersonelAdres p where p.personel.id = :personelId")
@ToString
public class PersonelAdres implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String adres;

	// bi-directional many-to-one association to Personel
	@ManyToOne
	@ToString.Exclude
	private Personel personel;

	public PersonelAdres() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Personel getPersonel() {
		return personel;
	}

	public void setPersonel(Personel personel) {
		this.personel = personel;
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
		PersonelAdres other = (PersonelAdres) obj;
		if (id != other.id)
			return false;
		return true;
	}

}