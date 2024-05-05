package com.example.testspringapr24;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productoffers")
public class Productoffer {
    @Id
    @Column(name = "id", length = 500)
    private String id;

    @Column(name = "hscode", length = 8)
    private String hscode;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "unitprice")
    private Integer unitprice;

    @Column(name = "offername", length = 50)
    private String offername;

    @Column(name = "sellername", length = 50)
    private String sellername;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

}
