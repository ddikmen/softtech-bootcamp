package com.softtech.softtech2ndassignment.service.entityservice;

import com.softtech.softtech2ndassignment.entity.District;
import com.softtech.softtech2ndassignment.repository.DistrictDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictEntityService {

    private final DistrictDao districtDao;

    public District save(District district){
        return districtDao.save(district);
    }

    public List<District> findAllByCityId(Long id){
        return districtDao.findAllByCityId(id);
    }

}
