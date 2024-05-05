package com.example.testspringapr24;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @Column(name = "walletid", nullable = false, length = 500)
    private String walletid;

    @Column(name = "balance")
    private Integer balance;

    @ColumnDefault("NULL")
    @Column(name = "state", length = 10)
    private String state;

    public String getWalletid() {
        return walletid;
    }

    public void setWalletid(String walletid) {
        this.walletid = walletid;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}