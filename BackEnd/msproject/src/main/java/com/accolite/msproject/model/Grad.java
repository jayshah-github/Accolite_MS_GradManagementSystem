package com.accolite.msproject.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Grad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false)
//    private Institute institute;
    @Column
    private String ten_join_date;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false)
//    private Location join_loc;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false)
//    private Location loc;

    @Column
    private String description;
    @Column
    private String feedback;
    @Column
    private String contact;
    @Column
    private String email;
    @Column
    private String grad_code;

    public Grad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public Institute getInstitute() {
//        return institute;
//    }
//
//    public void setInstitute(Institute institute) {
//        this.institute = institute;
//    }

    public String getTen_join_date() {
        return ten_join_date;
    }

    public void setTen_join_date(String ten_join_date) {
        this.ten_join_date = ten_join_date;
    }

//    public Location getJoin_loc() {
//        return join_loc;
//    }
//
//    public void setJoin_loc(Location join_loc) {
//        this.join_loc = join_loc;
//    }
//
//    public Location getLoc() {
//        return loc;
//    }
//
//    public void setLoc(Location loc) {
//        this.loc = loc;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrad_code() {
        return grad_code;
    }

    public void setGrad_code(String grad_code) {
        this.grad_code = grad_code;
    }
}
