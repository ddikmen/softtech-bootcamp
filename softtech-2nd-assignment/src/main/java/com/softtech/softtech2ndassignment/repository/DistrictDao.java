package com.softtech.softtech2ndassignment.repository;

import com.softtech.softtech2ndassignment.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictDao extends JpaRepository<District, Long> {

    List<District> findAllByCityId(Long id);

}
