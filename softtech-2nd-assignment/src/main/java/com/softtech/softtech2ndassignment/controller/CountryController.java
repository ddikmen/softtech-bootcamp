package com.softtech.softtech2ndassignment.controller;

import com.softtech.softtech2ndassignment.entity.Country;
import com.softtech.softtech2ndassignment.service.entityservice.CountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryEntityService countryEntityService;

    @PostMapping()
    public ResponseEntity saveCountry(@RequestBody Country country){

        country = countryEntityService.save(country);

        return ResponseEntity.ok(country);
    }

    @GetMapping("{code}")
    public ResponseEntity findByCountryCode(@PathVariable String code){

        Country country = countryEntityService.findByCountryCode(code);

        return ResponseEntity.ok(country);
    }
}
