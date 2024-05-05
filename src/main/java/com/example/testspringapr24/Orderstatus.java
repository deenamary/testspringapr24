package com.example.testspringapr24;


import jakarta.persistence.*;

@Entity
@Table(name = "orderstatuses")
public class Orderstatus
{

    @Id
    @Column(name = "id", nullable = false, length = 500)
    private String id;

    @Column(name = "orderid", nullable = false, length = 500)
    private String orderid;

    @Column(name = "status", length = 20)
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
