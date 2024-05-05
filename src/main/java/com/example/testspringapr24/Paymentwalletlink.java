package com.example.testspringapr24;

import jakarta.persistence.*;

@Entity
@Table(name = "paymentwalletlinks")
public class Paymentwalletlink {
    @Id
    @Column(name = "linkid", nullable = false, length = 500)
    private String linkid;

    @Column(name = "paymenttype", length = 10)
    private String paymenttype;

    @Column(name = "paymentrefid", nullable = false, length = 500)
    private String paymentrefid;

    @Column(name = "payerwallet", nullable = false, length = 500)
    private String payerwallet;

    @Column(name = "payeewallet", nullable = false, length = 500)
    private String payeewallet;

    @Column(name = "escrowwallet", nullable = false, length = 500)
    private String escrowwallet;

    @Column(name = "amount")
    private Integer amount;

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getPaymentrefid() {
        return paymentrefid;
    }

    public void setPaymentrefid(String paymentrefid) {
        this.paymentrefid = paymentrefid;
    }

    public String getPayerwallet() {
        return payerwallet;
    }

    public void setPayerwallet(String payerwallet) {
        this.payerwallet = payerwallet;
    }

    public String getPayeewallet() {
        return payeewallet;
    }

    public void setPayeewallet(String payeewallet) {
        this.payeewallet = payeewallet;
    }

    public String getEscrowwallet() {
        return escrowwallet;
    }

    public void setEscrowwallet(String escrowwallet) {
        this.escrowwallet = escrowwallet;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}