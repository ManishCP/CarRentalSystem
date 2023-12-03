package com.csye6220.carrentalsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.MaintenanceRecord;
import com.csye6220.carrentalsystem.model.Mechanic;
import com.csye6220.carrentalsystem.util.HibernateUtil;

@Repository
public class MechanicDAOImpl implements MechanicDAO {
	private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

	@Override
	public void createMechanic(Mechanic mechanic) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(mechanic);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public Mechanic getMechanicById(int mechanicID) {
		try(Session session = sessionFactory.openSession()){
			Mechanic mechanic = session.get(Mechanic.class, mechanicID);
            return mechanic;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public void updateMechanic(Mechanic mechanic) {
		 try(Session session = sessionFactory.openSession()){
	            Transaction transaction = session.getTransaction();
	            transaction.begin();
	            session.merge(mechanic);
	            transaction.commit();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteMechanic(int mechanicID) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Mechanic mechanic = getMechanicById(mechanicID);
            session.remove(mechanic);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public List<Mechanic> getAllMechanics() {
		try(Session session = sessionFactory.openSession()){
            List<Mechanic> mechanicList = session.createQuery("from Board", Mechanic.class).list();
            return mechanicList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public List<Car> getAssignedCarsByMechanic(int mechanicID) {
		try(Session session = sessionFactory.openSession()){
            String queryString = "FROM IssueCard i WHERE i.assignedTo.id = :userId";
            Query query = session.createQuery(queryString, Mechanic.class);
            query.setParameter("mechanicID", mechanicID);
            return query.list();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        
	}

	@Override
	public List<MaintenanceRecord> getMaintenanceRecords(int mechanicID) {
		try(Session session = sessionFactory.openSession()){
            String queryString = "FROM IssueCard i WHERE i.assignedTo.id = :userId";
            Query query = session.createQuery(queryString, Mechanic.class);
            query.setParameter("mechanicID", mechanicID);
            return query.list();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

}
