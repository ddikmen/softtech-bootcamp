package com.softtech.softtech2ndassignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "NEIGHBORHOOD")
@Getter
@Setter
public class Neighborhood {

    @Id
    @SequenceGenerator(name = "Neighborhood", sequenceName = "NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "Neighborhood")
    private Long id;

    @Column(name = "NEIGHBORHOOD_NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "ID_DISTRICT")
    private Long districtId;


}
