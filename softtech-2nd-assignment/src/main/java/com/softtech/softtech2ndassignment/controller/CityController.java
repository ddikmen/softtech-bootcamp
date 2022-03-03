package com.softtech.softtech2ndassignment.controller;

import com.softtech.softtech2ndassignment.entity.City;
import com.softtech.softtech2ndassignment.service.entityservice.CityEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityEntityService cityEntityService;

    @PostMapping
    public ResponseEntity saveCity(@RequestBody City city){

        city = cityEntityService.save(city);

        return ResponseEntity.ok(city);
    }

    @GetMapping("{plateCode}")
    public ResponseEntity findCityByPlateCode(@PathVariable String plateCode){

        City city = cityEntityService.findByPlateCode(plateCode);

        return ResponseEntity.ok(city);
    }


}
