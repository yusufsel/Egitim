package test;

import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import entities.Birlik;
import entities.Personel;
import entities.PersonelAdres;

public class Test1 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.PASS, "harita");
		properties.put(Environment.USER, "harita_user");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/harita?serverTimezone=UTC");

		configuration.setProperties(properties);

		configuration.addAnnotatedClass(Personel.class);
		configuration.addAnnotatedClass(PersonelAdres.class);
		configuration.addAnnotatedClass(Birlik.class);

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Query<Personel> query = session.createQuery("from Personel", Personel.class);
		List<Personel> personeller = query.list();
		personeller.forEach(p -> System.out.println(p.getAdi()));
	}

}
