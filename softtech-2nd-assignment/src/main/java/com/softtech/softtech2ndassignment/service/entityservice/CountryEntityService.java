package com.softtech.softtech2ndassignment.service.entityservice;

import com.softtech.softtech2ndassignment.repository.CountryDao;
import com.softtech.softtech2ndassignment.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryEntityService {

    private final CountryDao countryDao;

    public Country save(Country country){
        return countryDao.save(country);
    }

    public Country findByCountryCode(String countryCode){
        return countryDao.findByCode(countryCode);
    }
}
