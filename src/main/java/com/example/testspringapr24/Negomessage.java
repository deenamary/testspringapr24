package com.example.testspringapr24;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "negomessages")
public class Negomessage {
    @Id
    @Column(name = "id", nullable = false, length = 500)
    private String id;

    @Column(name = "negotype", length = 10)
    private String negotype;

    @Column(name = "negorefid", length = 500)
    private String negorefid;

    @Column(name = "sender", length = 10)
    private String sender;

    @Column(name = "receiver", length = 10)
    private String receiver;

    @Column(name = "message", length = Integer.MAX_VALUE)
    private String message;

    @Column(name = "time")
    private Instant time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNegotype() {
        return negotype;
    }

    public void setNegotype(String negotype) {
        this.negotype = negotype;
    }

    public String getNegorefid() {
        return negorefid;
    }

    public void setNegorefid(String negorefid) {
        this.negorefid = negorefid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    @Override
    public String toString()
    {
        return   sender+" --> "+receiver+": "+message;
    }
}
