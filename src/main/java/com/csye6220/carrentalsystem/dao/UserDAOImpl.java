package com.csye6220.carrentalsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.MyUserDetails;
import com.csye6220.carrentalsystem.model.User;
import com.csye6220.carrentalsystem.util.HibernateUtil;

@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
	
	@Override
	public void createUser(User user) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(user);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public User getUserByID(int userID) {
		try(Session session = sessionFactory.openSession()){
            User user = session.get(User.class, userID);
            return user;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public void update(User user) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(user);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public void delete(int userID) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            User user = session.get(User.class, userID);
            session.remove(user);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public List<User> getAllUsers() {
		try(Session session = sessionFactory.openSession()){
			return session.createQuery("from User",User.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

		
	@Override
    public User getUserByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("FROM User WHERE email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();
    }

	@Override
	public User getUserByUsername(String username) {
		try(Session session = sessionFactory.openSession()) {
            String queryString = "FROM User WHERE username = :username";
            Query query = session.createQuery(queryString, User.class).setParameter("username", username);
            List<User> users = query.list();
            return users.size() == 1 ? users.get(0) : null;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
	}

}
