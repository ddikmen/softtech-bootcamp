package com.softtech.softtech2ndassignment.repository;

import com.softtech.softtech2ndassignment.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetDao extends JpaRepository<Street, Long> {

    List<Street> findByNeighborhoodId(Long id);

}
