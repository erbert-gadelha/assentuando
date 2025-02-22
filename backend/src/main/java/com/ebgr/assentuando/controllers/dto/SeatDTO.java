package com.ebgr.assentuando.controllers.dto;

import java.time.LocalDateTime;

public record SeatDTO(
    Integer id,
    Integer seatNumber,
    String person,
    String theaterName,
    Integer thearId,
    LocalDateTime changedAt
) {
}
