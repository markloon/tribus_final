package hibernate;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TribusHibernateSessionFactory {

	private static final Configuration cfg = new Configuration();

	private static final ThreadLocal threadLocal = new ThreadLocal();

	private static SessionFactory sessionFactory;

	private static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";

	static {
		if (sessionFactory == null) {
			 
			try {								
				sessionFactory = (SessionFactory) cfg.configure(CONFIG_FILE_LOCATION)
						.buildSessionFactory();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void init() {

	}

	public static Session currentSession() throws HibernateException {
	//	return sessionFactory.getCurrentSession( );
		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				
				try {									
					sessionFactory = (SessionFactory) cfg.configure(CONFIG_FILE_LOCATION).buildSessionFactory();;
				} catch (Exception e) {
					System.err.println("%%%% Error Creating SessionFactory %%%%");
					e.printStackTrace();
				}
			}
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}

		return session;
	}

	public static Session getSession() throws HibernateException {
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void closeSessionFactory() throws HibernateException {
		if (sessionFactory != null && (!sessionFactory.isClosed())) {
			sessionFactory.close();
		}
	}

	private TribusHibernateSessionFactory() {
	}

}
