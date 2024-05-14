package com.capolavoroprova.capolavoro.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.capolavoroprova.capolavoro.Entity.Venditore;
import com.capolavoroprova.capolavoro.Services.VenditoreService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/venditore")
public class VenditoreController {
    @Autowired
    private VenditoreService venditoreService;

    @GetMapping
    public ResponseEntity<List<Venditore>> getAllCase() {
        return new ResponseEntity<List<Venditore>>(venditoreService.allVenditori(), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Venditore> createVenditore(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Venditore>(venditoreService.createVenditore(payload.get("nome"), payload.get("cognome"), Integer.parseInt(payload.get("idVenditore")), payload.get("idCasa")), HttpStatus.CREATED);
    }
    
}
