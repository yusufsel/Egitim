package hgm.gov.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the yetki database table.
 * 
 */
@Entity
@NamedQuery(name="Yetki.findAll", query="SELECT y FROM Yetki y")
public class Yetki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="yetki_adi")
	private String yetkiAdi;

	//bi-directional many-to-one association to PersonelYetki
	@OneToMany(mappedBy="yetki")
	private List<PersonelYetki> personelYetkis;

	public Yetki() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYetkiAdi() {
		return this.yetkiAdi;
	}

	public void setYetkiAdi(String yetkiAdi) {
		this.yetkiAdi = yetkiAdi;
	}

	public List<PersonelYetki> getPersonelYetkis() {
		return this.personelYetkis;
	}

	public void setPersonelYetkis(List<PersonelYetki> personelYetkis) {
		this.personelYetkis = personelYetkis;
	}

	public PersonelYetki addPersonelYetki(PersonelYetki personelYetki) {
		getPersonelYetkis().add(personelYetki);
		personelYetki.setYetki(this);

		return personelYetki;
	}

	public PersonelYetki removePersonelYetki(PersonelYetki personelYetki) {
		getPersonelYetkis().remove(personelYetki);
		personelYetki.setYetki(null);

		return personelYetki;
	}

}