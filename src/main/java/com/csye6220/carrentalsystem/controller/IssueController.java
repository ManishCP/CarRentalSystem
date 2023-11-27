//package com.csye6220.carrentalsystem.controller;
//
//import java.util.List;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author manis
// * 
// * 
// * IssueController
// * manage reported issues - creation; resolution; status updates
// *
// */
//@Controller
//@RequestMapping("/issues")
//public class IssueController {
//
//    private final IssueDAO issueDAO;
//
//    public IssueController(IssueDAO issueDAO) {
//        this.issueDAO = issueDAO;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<String> createIssue(@RequestBody Issue issue) {
//        
//        return ResponseEntity.ok("Issue reported successfully");
//    }
//
//    @PutMapping("/{issueID}")
//    public ResponseEntity<String> updateIssueStatus(@PathVariable int issueID, @RequestBody Issue updatedIssue) {
//        
//        return ResponseEntity.ok("Issue status updated successfully");
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<Issue>> getAllIssues() {
//        
//        return ResponseEntity.ok(issueDAO.getAllIssues());
//    }
//
//}
//
//
