package com.ebgr.assentuando.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ebgr.assentuando.models.SeatModel;
import com.ebgr.assentuando.models.TheaterModel;

public interface SeatRepository extends CrudRepository<SeatModel, Integer> {
    Optional<SeatModel> findByTheaterAndId(TheaterModel theater, int id);
    List<SeatModel> findByTheater(TheaterModel theater);
    List<SeatModel> findAll();
}
