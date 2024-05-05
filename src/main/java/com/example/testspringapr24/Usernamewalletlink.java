package com.example.testspringapr24;


import jakarta.persistence.*;

@Entity
@Table(name = "usernamewalletlinks")
public class Usernamewalletlink {
    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "walletid", nullable = false, length = 50)
    private String walletid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWalletid() {
        return walletid;
    }

    public void setWalletid(String walletid) {
        this.walletid = walletid;
    }

}
