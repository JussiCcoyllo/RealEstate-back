package jussics.realestate.repo;

import jussics.realestate.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssueRepo extends JpaRepository<Issue, Long > {
    Optional<Issue>findIssuesById(Long id);
    void deleteIssueById(Long id);
}
