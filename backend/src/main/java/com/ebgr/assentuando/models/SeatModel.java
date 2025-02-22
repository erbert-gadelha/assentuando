package com.ebgr.assentuando.models;

import java.time.LocalDateTime;

import com.ebgr.assentuando.controllers.dto.SeatDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class SeatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer seatNumber;
    String person;

    private LocalDateTime changedAt;   
    @ManyToOne(fetch = FetchType.EAGER)
    TheaterModel theater;

    public SeatModel() {}

    public SeatModel(Integer seat_number, String person, TheaterModel theater) {
        this.seatNumber = seat_number;
        this.person = person;
        this.theater = theater;
    }

}
