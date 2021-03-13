package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the calisan database table.
 * 
 */
@Embeddable
public class CalisanPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ise_giris_yili")
	private int iseGirisYili;

	@Column(name="sira_no")
	private int siraNo;

	public CalisanPK() {
	}
	public int getIseGirisYili() {
		return this.iseGirisYili;
	}
	public void setIseGirisYili(int iseGirisYili) {
		this.iseGirisYili = iseGirisYili;
	}
	public int getSiraNo() {
		return this.siraNo;
	}
	public void setSiraNo(int siraNo) {
		this.siraNo = siraNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CalisanPK)) {
			return false;
		}
		CalisanPK castOther = (CalisanPK)other;
		return 
			(this.iseGirisYili == castOther.iseGirisYili)
			&& (this.siraNo == castOther.siraNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iseGirisYili;
		hash = hash * prime + this.siraNo;
		
		return hash;
	}
}