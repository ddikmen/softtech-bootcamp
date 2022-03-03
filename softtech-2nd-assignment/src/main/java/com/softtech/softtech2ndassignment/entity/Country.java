package com.softtech.softtech2ndassignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRY")
@Getter
@Setter
public class Country {

    @Id
    @SequenceGenerator(name = "Country", sequenceName = "COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "Country")
    private Long id;

    @Column(name = "COUNTRY_CODE",length = 5, nullable = false, unique = true)
    private String code;

    @Column(name = "COUNTRY_NAME", length = 100, nullable = false)
    private String name;
}
