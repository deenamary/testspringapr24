package com.example.testspringapr24;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "paymentxns")
public class Paymentxn {
    @Id
    @Column(name = "txnid", nullable = false, length = 500)
    private String txnid;

    @Column(name = "paymenttype", length = 10)
    private String paymenttype;

    @Column(name = "pymntrefid", length = 500)
    private String pymntrefid;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "payerwallet", length = 500)
    private String payerwallet;

    @Column(name = "payeewallet", length = 500)
    private String payeewallet;

    @Column(name = "time")
    private Instant time;

    public String getTxnid() {
        return txnid;
    }

    public void setTxnid(String txnid) {
        this.txnid = txnid;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getPymntrefid() {
        return pymntrefid;
    }

    public void setPymntrefid(String pymntrefid) {
        this.pymntrefid = pymntrefid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

}
