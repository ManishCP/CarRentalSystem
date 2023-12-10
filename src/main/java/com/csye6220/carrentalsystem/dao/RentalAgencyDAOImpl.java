			package com.csye6220.carrentalsystem.dao;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.RentalAgency;
import com.csye6220.carrentalsystem.util.HibernateUtil;

@Repository
public class RentalAgencyDAOImpl implements RentalAgencyDAO {
	
	private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

	@Override
	public void createRentalAgency(RentalAgency agency) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(agency);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public RentalAgency getAgencyByID(int agencyID) {
		try(Session session = sessionFactory.openSession()){
            RentalAgency agency = session.get(RentalAgency.class, agencyID);
            return agency;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public void updateAgency(RentalAgency agency) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(agency);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public void deleteAgency(int agencyID) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            RentalAgency agency = getAgencyByID(agencyID);
            session.remove(agency);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public List<RentalAgency> getAllAgencies() {
		try(Session session = sessionFactory.openSession()){
			return session.createQuery("from RentalAgency",RentalAgency.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public List<Car> getAvailableCarsByAgency(int agencyID) {
		try(Session session = sessionFactory.openSession()){
            String queryString = "FROM Comment WHERE c.card.id = :cardId";
            Query query = session.createQuery(queryString, RentalAgency.class);
            query.setParameter("cardId", agencyID);
            return query.list();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

}
