package jussics.realestate.repo;

import jussics.realestate.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepo extends JpaRepository<Issue, Long > {
    Optional<Issue>findIssuesById(Long id);
    void deleteIssueById(Long id);

    @Query("select Issue(i.id, i.issueName, i.issueDate, i.issueDescription, i.user) from Issue i where i.user.id = ?1")
    List<Issue> findAllByUser(Long id);
}
