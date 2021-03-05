package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Personel;
import beans.PersonelAdres;

public class PersonelAdresDB extends DBBase {
	public List<PersonelAdres> getPersonelAdresler(int personelId) {
		List<PersonelAdres> personelAdresler = new ArrayList<PersonelAdres>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from personel_adres where personel_id = ?");
			stmt.setInt(1, personelId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				PersonelAdres personelAdres = new PersonelAdres();
				personelAdres.setId(rs.getInt("id"));
				personelAdres.setAdres(rs.getString("adres"));

				Personel personel = new Personel();
				personel.setId(personelId);

				personelAdres.setPersonel(personel);

				personelAdresler.add(personelAdres);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt);
		}
		return personelAdresler;
	}

	public void personelAdresSil(int personelAdresId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("delete from personel_adres where id = ?");
			stmt.setInt(1, personelAdresId);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}

	public void personelAdresEkle(PersonelAdres personelAdres) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("insert into personel_adres(personel_id, adres) values (?, ?)");
			stmt.setInt(1, personelAdres.getPersonel().getId());
			stmt.setString(2, personelAdres.getAdres());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}

	public void personelAdresGuncelle(int personelAdresId, PersonelAdres personelAdres) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("update personel_adres set personel_id = ?, adres = ? where id = ?");
			stmt.setInt(1, personelAdres.getPersonel().getId());
			stmt.setString(2, personelAdres.getAdres());
			stmt.setInt(3, personelAdresId);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}
}
