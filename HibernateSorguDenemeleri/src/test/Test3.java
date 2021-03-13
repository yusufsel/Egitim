package test;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import entities.Birlik;
import entities.Personel;
import entities.PersonelAdres;

public class Test3 {

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
		Query<Object[]> query = session.createQuery("select p.adi, p.soyadi, a.adres from Personel p join p.personelAdres a ", Object[].class);
		List<Object[]> sonuc = query.list();
		for (int i = 0; i < sonuc.size(); i++) {
			Object[] o = (Object[]) sonuc.get(i);
			for (int j = 0; j < o.length; j++) {
				System.out.print(o[j]);
				if (j < o.length - 1) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
		System.out.println("***************");
		sonuc.forEach(s -> System.out.println(Stream.of(s).map(String::valueOf).collect(Collectors.joining(","))));
	}

}
