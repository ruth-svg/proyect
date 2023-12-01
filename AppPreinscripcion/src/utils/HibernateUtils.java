package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Se configura Hibernate a partir del archivo.cfg.xml
			Configuration config = new Configuration().configure();
			// Añadimos la ruta a los hbm.xml
			config.configure().addResource("\\entidades\\Titulos.hbm.xml");
			config.configure().addResource("\\entidades\\Preinscripciones.hbm.xml");
			// Se construye la SessionFactory
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			return config.buildSessionFactory(sr);

		} catch (Throwable ex) {
			System.err.println("No se pudo crear la SessionFactory:" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
