package com.csye6220.carrentalsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.csye6220.carrentalsystem.model.Issue;
import com.csye6220.carrentalsystem.util.HibernateUtil;

@Repository
public class IssueDAOImpl implements IssueDAO {

	private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
	
	@Override
	public void createIssue(Issue issue) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(issue);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
		
	}

	@Override
	public Issue getIssueById(int issueID) {
		try(Session session = sessionFactory.openSession()){
            Issue issue = session.get(Issue.class, issueID);
            return issue;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public void updateIssue(Issue issue) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.merge(issue);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public void deleteIssue(int issueID) {
		try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Issue issue = getIssueById(issueID);
            session.remove(issue);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	@Override
	public List<Issue> getAllIssues() {
		try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Issues", Issue.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public List<Issue> getIssuesByCar(int carID) {
		try(Session session = sessionFactory.openSession()){
            String queryString = "FROM IssueCard i WHERE i.assignedTo.id = :userId";
            Query query = session.createQuery(queryString, Issue.class);
            query.setParameter("carID", carID);
            return query.list();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public List<Issue> getIssuesByUser(int userID) {
		try(Session session = sessionFactory.openSession()){
            String queryString = "FROM IssueCard i WHERE i.assignedTo.id = :userId";
            Query query = session.createQuery(queryString, Issue.class);
            query.setParameter("userID", userID);
            return query.list();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}

}
