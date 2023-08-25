package jussics.realestate.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String address;
    private Long number;
    private String district;
    private Long postalCode;
    private String description;

    public Property() {
    }

    public Property(Long id, String address, Long number, String district, Long postalCode, String description) {
        this.id = id;
        this.address = address;
        this.number = number;
        this.district = district;
        this.postalCode = postalCode;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", district='" + district + '\'' +
                ", postalCode=" + postalCode +
                ", description='" + description + '\'' +
                '}';
    }
}
