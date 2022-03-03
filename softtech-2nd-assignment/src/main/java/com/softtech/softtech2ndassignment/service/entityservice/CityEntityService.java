package com.softtech.softtech2ndassignment.service.entityservice;

import com.softtech.softtech2ndassignment.entity.City;
import com.softtech.softtech2ndassignment.repository.CityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityEntityService {

    private final CityDao cityDao;

    public City save(City city){

        return cityDao.save(city);

    }

    public City findByPlateCode(String plateCode){

        return cityDao.findByPlateCode(plateCode);

    }

}
