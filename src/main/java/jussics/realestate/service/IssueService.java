package jussics.realestate.service;

import jussics.realestate.exception.UserNotFoundException;
import jussics.realestate.model.Issue;
import jussics.realestate.model.Property;
import jussics.realestate.repo.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    private final IssueRepo issueRepo;

    @Autowired
    public IssueService(IssueRepo issueRepo){
        this.issueRepo = issueRepo;
    }
    public Issue addIssue(Issue issue){
        return issueRepo.save(issue);
    }
    public List<Issue> findAllIssues(){
        return issueRepo.findAll();
    }
    public Issue updateIssue(Issue issue){
        Issue iss = issueRepo.findById(issue.getId()).orElseThrow();
        iss.setIssueName(issue.getIssueName());
        iss.setIssueDate(issue.getIssueDate());
        iss.setIssueDescription(issue.getIssueDescription());
        return issueRepo.save(iss);
    }
    public Issue findIssueById(Long id){
        return issueRepo.findIssuesById(id)
                .orElseThrow(()-> new UserNotFoundException("Issue by id" + id + "is not found"));
    }
    public void deleteIssue(Long id){
        issueRepo.deleteIssueById(id);
    }

    public List<Issue> getIssuesByUserId(Long id){
        return issueRepo.findAllByUser(id);
    }
}
