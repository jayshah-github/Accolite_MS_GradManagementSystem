package com.accolite.msproject.model;

import javax.persistence.*;


@Entity
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
}
