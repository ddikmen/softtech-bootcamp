package com.softtech.softtech2ndassignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
@Getter
@Setter
public class City {

    @Id
    @SequenceGenerator(name = "City", sequenceName = "CITY_ID_SEQ")
    @GeneratedValue(generator = "City")
    private long id;

    @Column(name = "CITY_PLATE_CODE", length = 5, nullable = false)
    private String plateCode;

    @Column(name = "CITY_NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "ID_COUNTRY")
    private Long countryId;

}
