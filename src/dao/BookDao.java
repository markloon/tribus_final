package dao;

import hibernate.TribusHibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class BookDao {

	
	public long add( BookDao book ) throws Exception {
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
			session.save( book );
			session.flush();					
			tx.commit( );			
			return -1;						
		} catch ( Exception e ) {
			tx.rollback( );			
		}
		return -1;
	}
	
	

	
	public void update( BookDao book ) throws Exception {
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
			session.update( book );
			tx.commit( );
		} catch ( Exception e ) {
			tx.rollback( );
			throw new Exception( e.getCause( ).getMessage( ) );
		}
	}
	
	

	public void delete( BookDao book ) throws Exception {
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
			session.delete( book );
			tx.commit( );
		} catch ( Exception e ) {
			tx.rollback( );
			throw e;
		}
	}
}
