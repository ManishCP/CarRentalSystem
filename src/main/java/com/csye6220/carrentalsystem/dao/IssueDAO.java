package com.csye6220.carrentalsystem.dao;

import java.util.List;

import com.csye6220.carrentalsystem.model.Issue;

public interface IssueDAO {
	void createIssue(Issue issue);
	Issue getIssueById(int issueID);
	void updateIssue(Issue issue);
	void deleteIssue(int issueID);
	
	List<Issue> getAllIssues();
	List<Issue> getIssuesByCar(int carID);
	List<Issue> getIssuesByUser(int userID);

}
