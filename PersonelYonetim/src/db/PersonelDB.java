package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Personel;
import exceptions.db.ReadException;

public class PersonelDB extends DBBase {
	public List<Personel> getPersonelListesi() throws ReadException {
		List<Personel> personeller = new ArrayList<Personel>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from personel");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Personel personel = new Personel();
				personel.setId(rs.getInt("id"));
				personel.setTcNo(rs.getString("tcno"));
				personel.setAdi(rs.getString("adi"));
				personel.setSoyadi(rs.getString("soyadi"));
				personeller.add(personel);
			}
		} catch (Exception e) {
			throw new ReadException("personel", e);
		} finally {
			close(rs, stmt);
		}
		return personeller;
	}
}
