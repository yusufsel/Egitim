package test;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import entities.Birlik;
import entities.Calisan;
import entities.Personel;
import entities.PersonelAdres;

public class Test7Level1Cache {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.PASS, "harita");
		properties.put(Environment.USER, "harita_user");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/harita?serverTimezone=UTC");
		properties.put(Environment.SHOW_SQL, "true");

		configuration.setProperties(properties);

		configuration.addAnnotatedClass(Personel.class);
		configuration.addAnnotatedClass(PersonelAdres.class);
		configuration.addAnnotatedClass(Birlik.class);
		configuration.addAnnotatedClass(Calisan.class);

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Personel personel = session.get(Personel.class, 6);
		System.out.println(personel);

		Personel personel2 = session.get(Personel.class, 6);
		System.out.println(personel2);
		session.close();
		session = factory.openSession();
		personel = session.get(Personel.class, 6);
		System.out.println(personel);

		personel2 = session.get(Personel.class, 6);
		System.out.println(personel2);
		session.close();
	}

}
