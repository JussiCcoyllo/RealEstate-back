package jussics.realestate.resource;


import jakarta.transaction.Transactional;
import jussics.realestate.model.Issue;
import jussics.realestate.service.IssueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/issue")
public class IssueResource {
    private final IssueService issueService;

    public IssueResource(IssueService issueService){
        this.issueService=issueService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Issue>> getAllIssues(){
        List<Issue> issues=issueService.findAllIssues();
        return new ResponseEntity<>(issues, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable("id") Long id){
        Issue issue = issueService.findIssueById(id);
        return new ResponseEntity<>(issue, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Issue> addIssue(@RequestBody Issue issue) {
        Issue newIssue = issueService.addIssue(issue);
        return new ResponseEntity<>(newIssue, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Issue> updateIssue(@RequestBody Issue issue) {
        Issue updateIssue = issueService.updateIssue(issue);
        return new ResponseEntity<>(updateIssue, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIssue(@PathVariable("id") Long id) {
        issueService.deleteIssue(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/user/{id}")
    public List<Issue> getIssuesByUserId(@PathVariable("id") Long id){
        return issueService.getIssuesByUserId(id);
    }
}
