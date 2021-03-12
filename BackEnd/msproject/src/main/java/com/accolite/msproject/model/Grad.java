package com.accolite.msproject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Grad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Institute institute;

    @Column
    private String ten_join_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Location join_loc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Location loc;

    @Column
    private String description;
    @Column
    private String feedback;
    @Column
    private String contact;
    @Column
    private String email;

//    @ManyToMany( fetch = FetchType.EAGER)

    @ManyToMany( fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "grad_skills",
//            joinColumns = {@JoinColumn(name = "grad_id")},
//            inverseJoinColumns = {@JoinColumn(name = "skills_id")}
//    )
    private Set<Skill> skills = new HashSet<>();

    public Grad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public String getTen_join_date() {
        return ten_join_date;
    }

    public void setTen_join_date(String ten_join_date) {
        this.ten_join_date = ten_join_date;
    }

    public Location getJoin_loc() {
        return join_loc;
    }

    public void setJoin_loc(Location join_loc) {
        this.join_loc = join_loc;
    }

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

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
