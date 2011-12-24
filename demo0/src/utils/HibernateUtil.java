package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		sessionFactory = new Configuration().configure() // configures settings
															// from
															// hibernate.cfg.xml
				.buildSessionFactory();
		return sessionFactory;
	}
	
	public static void closeSessionFactory(){
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}
}
