package com.softtech.softtech2ndassignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DISTRICT")
@Getter
@Setter
public class District {

    @Id
    @SequenceGenerator(name = "District", sequenceName = "DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "District")
    private Long id;

    @Column(name = "DISTRICT_NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "ID_CITY")
    private Long cityId;

}
