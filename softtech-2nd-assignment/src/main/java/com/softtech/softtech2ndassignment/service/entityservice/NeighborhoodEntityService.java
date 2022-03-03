package com.softtech.softtech2ndassignment.service.entityservice;

import com.softtech.softtech2ndassignment.entity.Neighborhood;
import com.softtech.softtech2ndassignment.repository.NeighborhoodDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NeighborhoodEntityService {

    private final NeighborhoodDao neighborhoodDao;

    public Neighborhood saveNeighborHood(Neighborhood neighborhood){

        return neighborhoodDao.save(neighborhood);

    }

    public Neighborhood updateNeighborhoodName(Long id, String name){

        Optional<Neighborhood> neighborhoodOptional = neighborhoodDao.findById(id);

        Neighborhood neighborhood;

        if(neighborhoodOptional.isPresent()){

            neighborhood = neighborhoodOptional.get();

        }else{
            throw new RuntimeException("Item not found!");
        }

        neighborhood.setName(name);

        return neighborhoodDao.save(neighborhood);
    }

    public List<Neighborhood> getAllNeighboorhoodByDstrıctId(Long id){

        return neighborhoodDao.findAllByDistrictId(id);

    }

}
