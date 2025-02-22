package com.ebgr.assentuando.controllers.dto;

import java.util.List;

public record TheaterAndSeatsDTO(
    Integer id,
    String name,
    List<SeatDTO> seats    
) {
    
}
