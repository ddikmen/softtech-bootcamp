package com.softtech.softtech2ndassignment.controller;

import com.softtech.softtech2ndassignment.entity.District;
import com.softtech.softtech2ndassignment.service.entityservice.DistrictEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/districts")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictEntityService districtEntityService;

    @PostMapping
    public ResponseEntity saveDistrict(@RequestBody District district){

        district = districtEntityService.save(district);

        return ResponseEntity.ok(district);
    }

    @GetMapping("{cityId}")
    public ResponseEntity getDistrictsByCityId(@PathVariable Long cityId){

        List<District> districtList = districtEntityService.findAllByCityId(cityId);

        return ResponseEntity.ok(districtList);
    }



}
