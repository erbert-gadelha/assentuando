package com.ebgr.assentuando.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebgr.assentuando.controllers.dto.SeatDTO;
import com.ebgr.assentuando.models.SeatModel;
import com.ebgr.assentuando.models.TheaterModel;
import com.ebgr.assentuando.repository.SeatRepository;
import com.ebgr.assentuando.repository.TheaterRepository;

@Component
public class SeatService {
    @Autowired
    SeatRepository seatRepository;

    @Autowired
    TheaterRepository theaterRepository;
    
    public static SeatDTO seatDTO(SeatModel seat, TheaterModel theater) {
        return new SeatDTO(seat.getId(), seat.getSeatNumber(), seat.getPerson(), theater.getName(), theater.getId(), seat.getChangedAt());
    }

    public SeatDTO get(Integer seatId, Integer theaterId) {
        final Optional<TheaterModel> theater = theaterRepository.findById(theaterId);
        if(theater.isEmpty())
            return null;
        final Optional<SeatModel> seat = seatRepository.findByTheaterAndSeatNumber(theater.get(), seatId);
        if(seat.isEmpty())
            return null;
        return seatDTO(seat.get(), theater.get());
    }

    public SeatDTO set(Integer seatId, Integer theaterId, String person) {
        final Optional<TheaterModel> theater = theaterRepository.findById(theaterId);
        if(theater.isEmpty())
            return null;

        final Optional<SeatModel> seat = seatRepository.findByTheaterAndSeatNumber(theater.get(), seatId);
        if(seat.isEmpty())
            return null;        

        boolean isEmpty = person == null || person.isEmpty();
        seat.get().setPerson(isEmpty?null:person);
        seat.get().setChangedAt(isEmpty?null:LocalDateTime.now());
        seatRepository.save(seat.get());        

        return seatDTO(seat.get(), theater.get());
    }
    
}
