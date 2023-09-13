package jussics.realestate.model;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="issue_tenant")
public class Issue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issueName;
    private String issueDate;
    private String issueDescription;

    public Issue(){
    }
    @ManyToOne
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", issueName='" + issueName + '\'' +
                ", issueDate=" + issueDate +
                ", issueDescription='" + issueDescription + '\'' +
                '}';
    }
}
