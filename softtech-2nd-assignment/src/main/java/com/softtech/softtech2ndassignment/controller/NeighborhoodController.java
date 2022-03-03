package com.softtech.softtech2ndassignment.controller;

import com.softtech.softtech2ndassignment.entity.Neighborhood;
import com.softtech.softtech2ndassignment.service.entityservice.NeighborhoodEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/neighborhoods")
@RequiredArgsConstructor
public class NeighborhoodController {

    private final NeighborhoodEntityService neighborhoodEntityService;

    @PostMapping
    public ResponseEntity saveNeighborhood(@RequestBody Neighborhood neighborhood){

        neighborhood = neighborhoodEntityService.saveNeighborHood(neighborhood);

        return ResponseEntity.ok(neighborhood);

    }

    @PatchMapping("/{id}")
    public ResponseEntity updateNeighborhood(@PathVariable Long id, @RequestParam String name){

        Neighborhood neighborhood = neighborhoodEntityService.updateNeighborhoodName(id,name);

        return ResponseEntity.ok(neighborhood);

    }

    @GetMapping("{id}")
    public ResponseEntity getAllNeighboorhoodByDstrıctId(@PathVariable Long id){

        List<Neighborhood> neighborhoodList = neighborhoodEntityService.getAllNeighboorhoodByDstrıctId(id);

        return ResponseEntity.ok(neighborhoodList);

    }

}
