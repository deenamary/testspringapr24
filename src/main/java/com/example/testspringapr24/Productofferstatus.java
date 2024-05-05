package com.example.testspringapr24;


import jakarta.persistence.*;

@Entity
@Table(name = "productofferstatuses")
public class Productofferstatus {

    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "offerid", nullable = false, length = 10)
    private String offerid;

    @Column(name = "status", length = 10)
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfferid() {
        return offerid;
    }

    public void setOfferid(String offerid) {
        this.offerid = offerid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
