package com.ebgr.assentuando.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ebgr.assentuando.controllers.dto.SeatDTO;
import com.ebgr.assentuando.controllers.dto.TheaterAndSeatsDTO;
import com.ebgr.assentuando.controllers.dto.TheaterDTO;
import com.ebgr.assentuando.models.SeatModel;
import com.ebgr.assentuando.models.TheaterModel;
import com.ebgr.assentuando.repository.SeatRepository;
import com.ebgr.assentuando.repository.TheaterRepository;

@Component
public class TheatherService {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    SeatRepository seatRepository;

    static final int MAX_SEATS = 3;



    public static TheaterDTO theaterDTO(TheaterModel theater) {
        return new TheaterDTO(theater.getId(), theater.getName());
    }

    public TheaterAndSeatsDTO theaterAndSeatsDTO(TheaterModel theater) {
        final List<SeatModel> seatModels = seatRepository.findByTheater(theater);
        return new TheaterAndSeatsDTO(
                theater.getId(),
                theater.getName(),
                seatModels.stream().map(seat -> SeatService.seatDTO(seat, theater)).collect(Collectors.toList())
                );
    }


    public List<TheaterDTO> getAll() {
        return theaterRepository.findAll().stream().map(TheatherService::theaterDTO).collect(Collectors.toList());
    }


    public TheaterAndSeatsDTO find(Integer id) {
        Optional<TheaterModel> theater = theaterRepository.findById(id);
        if(!theater.isPresent())
            return null;
        return theaterAndSeatsDTO(theater.get());
    }

    public TheaterDTO changeName(String newName, int id) {
        Optional<TheaterModel> theater = theaterRepository.findById(id);
        if(theater.isEmpty())
            return null;
        theater.get().setName(newName);
        theaterRepository.save(theater.get());
        return theaterDTO(theater.get());
    }

    public TheaterDTO delete(int id) {
        Optional<TheaterModel> theater = theaterRepository.findById(id);
        if(theater.isEmpty())
            return null;
        
        TheaterDTO dto = theaterDTO(theater.get());
        seatRepository.deleteAll(seatRepository.findByTheater(theater.get()));            
        theaterRepository.delete(theater.get());
        return dto;
    }




    public TheaterDTO create(final String name) {
        TheaterModel theater = theaterRepository.save(new TheaterModel(name));        
        for (int i = 0; i < MAX_SEATS; i++)
            seatRepository.save(new SeatModel(i, null, theater)); 
        return theaterDTO(theater);
    }
    
}
