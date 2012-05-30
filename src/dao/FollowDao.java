package dao;

import java.util.ArrayList;
import java.util.List;

import hibernate.TribusHibernateSessionFactory;
import model.Follow;
import model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class FollowDao {
	
	
	public int add(Follow follow){
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
			session.save( follow );
	//		session.flush();
			tx.commit( );			
			return 1;		
			
		} catch ( Exception e ) {
			tx.rollback( );			
		}
		return -1;
	}
	
	
	public List<User> getAllFriends(int userId){		
		List<User> followees = new ArrayList<User>();		
		Session session = TribusHibernateSessionFactory.currentSession();		
		try {
			followees = session.createSQLQuery(
					"select user_account.* " +
					"from " +
					"user_account, follow " +					
					"where " +
					"user_account.userId = follow.followeeId " +
					"and " +
					"follow.followerId = '"+userId+"'")
			.addEntity(User.class).list();														
		} catch ( Exception e ) {			
			e.printStackTrace();
		}
		return followees;
	}
		
	public void update( Follow follow ) {
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
			session.update( follow );
			tx.commit( );
		} catch ( Exception e ) {
			tx.rollback( );
			System.out.println(e.getCause( ).getMessage( ));			
		}
	}

}
