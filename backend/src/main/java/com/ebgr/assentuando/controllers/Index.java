package com.ebgr.assentuando.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.net.http.HttpResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@Tag(name = "Index", description = "Rota inicial da aplicacao.")
public class Index {

    @GetMapping("/")
    @Operation(summary = "Status", description = "Confirma que a aplicacao iniciou de forma adequada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Container está funcionando")
    })
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok().body("container is up");
    }
    
}
