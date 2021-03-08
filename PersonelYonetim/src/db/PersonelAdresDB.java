package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Personel;
import beans.PersonelAdres;
import exceptions.db.CreateException;
import exceptions.db.DeleteException;
import exceptions.db.ReadException;
import exceptions.db.UpdateException;

public class PersonelAdresDB extends DBBase {
	public List<PersonelAdres> getPersonelAdresler(int personelId) throws ReadException {
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
		} catch (Exception e) {
			throw new ReadException("personel_adres", e);
		} finally {
			close(rs, stmt);
		}
		return personelAdresler;
	}

	public PersonelAdres getPersonelAdres(int personelAdresId) throws ReadException {
		PersonelAdres personelAdres = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from personel_adres where id = ?");
			stmt.setInt(1, personelAdresId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				personelAdres = new PersonelAdres();
				personelAdres.setId(rs.getInt("id"));
				personelAdres.setAdres(rs.getString("adres"));

				Personel personel = new Personel();
				personel.setId(rs.getInt("personel_id"));

				personelAdres.setPersonel(personel);
			}
		} catch (Exception e) {
			throw new ReadException("personel_adres", e);
		} finally {
			close(rs, stmt);
		}
		return personelAdres;
	}

	public void personelAdresSil(int personelAdresId) throws DeleteException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("delete from personel_a2dres where id = ?");
			stmt.setInt(1, personelAdresId);
			stmt.execute();
		} catch (Exception e) {
			throw new DeleteException("personel_adres", e);
		} finally {
			close(stmt);
		}
	}

	public void personelAdresEkle(PersonelAdres personelAdres) throws CreateException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("insert into personel_adres(personel_id, adres) values (?, ?)");
			stmt.setInt(1, personelAdres.getPersonel().getId());
			stmt.setString(2, personelAdres.getAdres());
			stmt.execute();
		} catch (Exception e) {
			throw new CreateException("personel_adres", e);
		} finally {
			close(stmt);
		}
	}

	public void personelAdresGuncelle(int personelAdresId, PersonelAdres personelAdres) throws UpdateException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("update personel_adres set adres = ? where id = ?");
			stmt.setString(1, personelAdres.getAdres());
			stmt.setInt(2, personelAdresId);
			stmt.execute();
		} catch (Exception e) {
			throw new UpdateException("personel_adres", e);
		} finally {
			close(stmt);
		}
	}
}
