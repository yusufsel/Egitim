package db;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBBase {
	private static ThreadLocal<EntityManager> entityManager = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory emFactory;

	public static EntityManagerFactory getEmFactory() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("localMySql");
		}
		return emFactory;
	}

	protected EntityManager getConnection() throws SQLException {
		if (entityManager.get() == null) {
			entityManager.set(getEmFactory().createEntityManager());
		}
		return entityManager.get();
	}

	public static void closeEntityManager() {
		try {
			entityManager.get().close();
			entityManager.remove();
		} catch (Exception e) {
		}
	}
}
