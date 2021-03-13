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

public class Test9Level2Cache {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.PASS, "harita");
		properties.put(Environment.USER, "harita_user");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/harita?serverTimezone=UTC");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
		properties.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");

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
		//@formatter:off
		/*
		 * Fetch tipi Eager verilse bile tek select te kaç seviye okunacaðýný sýnýrlar.
		 * <property name="hibernate.max_fetch_depth" value="2"/>
		 * 
		 * Native sorgular cache'lenmez. 
		 * session.createSQLQuery("select * from Foo")
		 * .setHint("org.hibernate.cacheable", true) .getResultList();
		 * 
		 * HQL sorgular da cache'lenmez. 
		 * session.createQuery("select f from Foo f")
		 * .setHint("org.hibernate.cacheable", true) .getResultList();
		 * 
		 * Native query ile update yapýldýðýna neyin güncellendiðini hibernate bilemediðinden
		 * tüm cache silinir.
		 * 
		 * nativeQuery = session.createNativeQuery("update FOO set ... where ...");
		 * nativeQuery.unwrap(org.hibernate.SQLQuery.class).addSynchronizedEntityClass(Foo.class);
		 * nativeQuery.executeUpdate();
		 * 
		 * aþaðýdaki ayar ise cache özelliðini tüm entitiy'ler için otomatik olarak açar.
         * Entity sýnýflarýna @Cache yazmak zorunda kalmayýz ama kesinlikle tavsiye edilmez.         
         * <property name="javax.persistence.sharedCache.mode">DISABLE_SELECTIVE</property>
         * properties.put(Environment.JPA_SHARED_CACHE_MODE, "DISABLE_SELECTIVE");
		 */
		//@formatter:on
	}

}
