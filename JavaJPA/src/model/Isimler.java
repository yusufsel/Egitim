package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the isimler database table.
 * 
 */
@Entity
@NamedQuery(name="Isimler.findAll", query="SELECT i FROM Isimler i")
public class Isimler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String isim;

	public Isimler() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return this.isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

}