package com.ebgr.assentuando.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebgr.assentuando.controllers.dto.TheaterAndSeatsDTO;
import com.ebgr.assentuando.controllers.dto.TheaterDTO;
import com.ebgr.assentuando.service.TheatherService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/1/theater/")
public class TheaterController {   

    @Autowired
    TheatherService service;

    @GetMapping("/")
    public ResponseEntity<List<TheaterDTO>> getAll() {
        return ResponseEntity
        .ok()
        .body(
            service.getAll()); 
    }

    @PutMapping("{id}")
    public ResponseEntity<TheaterDTO> changeTheaterName(@RequestBody(required = true) String newName, @PathVariable(name="id", required = true) final Integer id) {
        TheaterDTO theater = service.changeName(newName, id);
        if(theater == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(theater);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TheaterDTO> deleteTheater(@PathVariable(name = "id", required = true) final Integer id) {
        TheaterDTO theater = service.delete(id);
        if(theater == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(theater);
    }

    


    @GetMapping("{id}")
    public ResponseEntity<TheaterAndSeatsDTO> getTheater(@PathVariable(name = "id", required = true) final Integer id) {
        TheaterAndSeatsDTO theater = service.find(id);
        if(theater == null)
            return ResponseEntity
                .noContent()
                .build();
        return ResponseEntity
            .ok()
            .body(theater);                 
    }
    

    @PostMapping("/{name}")
    public ResponseEntity<TheaterDTO> createTheater(@PathVariable(required = true, name = "name") final String name) {
        System.out.println("name: " + name);

        return ResponseEntity
        .created(null)
        .body(
            service.create(name));        
    }
}
