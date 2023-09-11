package jussics.realestate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="issueTenant")
public class Issue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issueName;
    private String issueDate;
    private String issueDescription;

    public Issue(){
    }

    public Issue(Long id, String issueName, String issueDate, String issueDescription) {
        this.id = id;
        this.issueName = issueName;
        this.issueDate = issueDate;
        this.issueDescription = issueDescription;
    }

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
