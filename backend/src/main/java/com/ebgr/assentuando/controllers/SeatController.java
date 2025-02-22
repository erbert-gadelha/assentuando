package com.ebgr.assentuando.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ebgr.assentuando.controllers.dto.SeatDTO;
import com.ebgr.assentuando.service.SeatService;

import jakarta.websocket.server.PathParam;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/1/seat/")
public class SeatController {

    @Autowired
    SeatService seatService;


    @GetMapping("{theater}/{seat}")
    public ResponseEntity<SeatDTO> getSeat(@PathVariable Integer theater, @PathVariable Integer seat) {
        SeatDTO seatDto = seatService.get(seat, theater);
        if(seatDto == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(seatDto);
    }

    @PutMapping("{theater}/{seat}")
    public ResponseEntity<SeatDTO> setSeat(@RequestBody(required = false) String person, @PathVariable Integer theater, @PathVariable Integer seat) {
        SeatDTO seatDto = seatService.set(seat, theater, person);
        if(seatDto == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(seatDto);
    }
    
}
