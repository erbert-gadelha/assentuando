package com.ebgr.assentuando.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ebgr.assentuando.models.TheaterModel;

public interface TheaterRepository extends CrudRepository<TheaterModel, Integer> {
    Optional<TheaterModel> findUserById(Integer id);
    List<TheaterModel> findAll();    
}
