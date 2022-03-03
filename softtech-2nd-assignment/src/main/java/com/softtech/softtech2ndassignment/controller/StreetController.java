package com.softtech.softtech2ndassignment.controller;

import com.softtech.softtech2ndassignment.entity.Street;
import com.softtech.softtech2ndassignment.service.entityservice.StreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/streets")
@RequiredArgsConstructor
public class StreetController {

    private final StreetEntityService streetEntityService;

    @PostMapping
    public ResponseEntity saveStreet(@RequestBody Street street){

        street = streetEntityService.save(street);

        return ResponseEntity.ok(street);
    }

    @PatchMapping("{id}")
    public ResponseEntity updateStreetName(@PathVariable Long id, @RequestParam String name){

        Street street = streetEntityService.updateStreetName(id,name);

        streetEntityService.save(street);

        return ResponseEntity.ok(street);
    }

    @GetMapping("{id}")
    public ResponseEntity getAllStreetByNeighborhoodId(@PathVariable Long id){

        List<Street> streetList = streetEntityService.getAllStreetByNeighborhoodId(id);

        return ResponseEntity.ok(streetList);

    }




}
