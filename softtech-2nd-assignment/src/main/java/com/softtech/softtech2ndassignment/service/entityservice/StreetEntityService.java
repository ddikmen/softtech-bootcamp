package com.softtech.softtech2ndassignment.service.entityservice;

import com.softtech.softtech2ndassignment.entity.Street;
import com.softtech.softtech2ndassignment.repository.StreetDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreetEntityService {

    private final StreetDao streetDao;

    public Street save(Street street){

        return streetDao.save(street);

    }

    public Street updateStreetName(Long id, String name){

        Optional<Street> streetOptional = streetDao.findById(id);

        Street street;

        if(streetOptional.isPresent()){

            street = streetOptional.get();

        }else{
            throw new RuntimeException("Item not found!");
        }

        street.setName(name);

        return streetDao.save(street);
    }

    public List<Street> getAllStreetByNeighborhoodId(Long id){

        List<Street> streetList = streetDao.findByNeighborhoodId(id);

        return streetList;
    }

}
