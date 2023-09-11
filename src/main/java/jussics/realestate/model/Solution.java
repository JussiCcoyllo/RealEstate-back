package jussics.realestate.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="solution")
public class Solution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String status;
    private String descriptionSolution;

    public Solution() {
    }

    public Solution(Long id, String status, String descriptionSolution) {
        this.id = id;
        this.status = status;
        this.descriptionSolution = descriptionSolution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescriptionSolution() {
        return descriptionSolution;
    }

    public void setDescriptionSolution(String descriptionSolution) {
        this.descriptionSolution = descriptionSolution;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", descriptionSolution='" + descriptionSolution + '\'' +
                '}';
    }
}
