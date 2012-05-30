package dao;

import hibernate.TribusHibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao { 
	
	@SuppressWarnings("unchecked")
	public User haveRegistered(String name, String pwd){
		
		User u = null;
		Session session = TribusHibernateSessionFactory.currentSession();		
		try {
			List<User> user = session.createSQLQuery("select id from user_account where userEmail = ? and userPw = ?")
			.addEntity(User.class)			
			.setString(0,name)
			.setString(1, pwd).list();			
			
			if(user!=null && user.get(0)!=null){
				u = (User)user.get(0);
				//if(u.getStatus() == 1){
					return u;
				//}else{
					//return u;
				//}
			}											
		} catch ( Exception e ) {
			System.out.println(e.getMessage());			
		}				
		return u;
	}
	
	public int add( User user ) {
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
			session.save( user );
	//		session.flush();
			tx.commit( );			
			return 1;		
			
		} catch ( Exception e ) {
			tx.rollback( );			
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserById(int id){
		User u = null;
		Session session = TribusHibernateSessionFactory.currentSession();		
		try {			
			List<User> user = session.
			createSQLQuery("select * from user_account where userId = '"+id+"'")
			.addEntity(User.class)						
			.list();			
			
			//Criteria c = new org.hibernate.criterion.
			
			if(user!=null && user.get(0)!=null){
				u = (User)user.get(0);				
			}								
			
			return u;
		} catch ( Exception e ) {
			System.out.println(e.getMessage());			
		}				
		return u;
	}
	
	public void update( User user ) {
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
			session.update( user );
			tx.commit( );
		} catch ( Exception e ) {
			tx.rollback( );
			System.out.println(e.getCause( ).getMessage( ) );
		}
	}
	
	public void delete( User user ) throws Exception {
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
			session.delete( user );
			tx.commit( );
		} catch ( Exception e ) {
			tx.rollback( );
			throw e;
		}
	}
	
	

	public int follow(int userId,int friendId){					
		Session session = TribusHibernateSessionFactory.currentSession();
		Transaction tx = session.beginTransaction( );
		try {
		    	
			
																						
		} catch ( Exception e ) {			
			System.out.println(e.getMessage());
		}
		return 1;
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
					"follow.followerId = ?")
			.addEntity(User.class).setInteger(0, userId).list();														
		} catch ( Exception e ) {			
			System.out.println(e.getMessage());
		}
		return followees;
	}
	
	
	@SuppressWarnings("unchecked")
	public User isEmailUsed(String email){		
		User u = null;
		List<User> followees = new ArrayList<User>();		
		Session session = TribusHibernateSessionFactory.currentSession();		
		try {
			followees = session.createSQLQuery(
					"select user_account.userId " +
					"from " +
					"user_account " +					
					"where " +
					"user_account.userEmail = ? ")
			.addEntity(User.class).setString(0, email).list();
			
			if(followees !=null && followees.size() > 0){
				u = followees.get(0);
			}
			
		} catch ( Exception e ) {			
			System.out.println(e.getMessage());
		}
		return u;
	}
	
	
	public static void main(String[] args){
		//UserDao ud = new UserDao();
		//List<User> u = ud.getAllFriends(1);
		//System.out.println(u);
	}
	
}