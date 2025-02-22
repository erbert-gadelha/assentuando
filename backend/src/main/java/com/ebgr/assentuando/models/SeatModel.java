package com.ebgr.assentuando.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SeatModel {
    @Id
    Integer id;
    String person;

    private LocalDateTime changedAt;   
    @ManyToOne(fetch = FetchType.EAGER)
    TheaterModel theater;
}
