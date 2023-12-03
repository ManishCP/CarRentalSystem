package com.csye6220.carrentalsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.carrentalsystem.dao.IssueDAO;
import com.csye6220.carrentalsystem.model.Issue;

@Service
public class IssueService {

	@Autowired
	private IssueDAO issueDAO;
	
	public void createIssue(Issue issue) {
		issueDAO.createIssue(issue);
	}

	public Issue getIssueById(int issueID) {
		return issueDAO.getIssueById(issueID);
	}

	public void updateIssue(Issue issue) {
		issueDAO.updateIssue(issue);
	}

	public void deleteIssue(int issueID) {
		issueDAO.deleteIssue(issueID);
	}

	public List<Issue> getAllIssues() {
		return issueDAO.getAllIssues();
	}

	public List<Issue> getIssuesByCar(int carID) {
		return issueDAO.getIssuesByCar(carID);
	}

	public List<Issue> getIssuesByUser(int userID) {
		return issueDAO.getIssuesByUser(userID);
	}

}
