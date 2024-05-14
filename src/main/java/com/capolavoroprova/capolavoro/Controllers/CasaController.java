package com.capolavoroprova.capolavoro.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.capolavoroprova.capolavoro.Entity.Casa;
import com.capolavoroprova.capolavoro.Models.CasaModel;
import com.capolavoroprova.capolavoro.Services.CasaService;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/caseList")
public class CasaController {

    @Autowired
    private CasaService casaService;

    @GetMapping
    public ResponseEntity<List<Casa>> getAllCase() {
        return new ResponseEntity<List<Casa>>(casaService.allCase(), HttpStatus.OK);
    }
    
    @GetMapping("/{idCasa}")
    public ResponseEntity<Optional<Casa>> getCasa(@PathVariable String idCasa) {
        return new ResponseEntity<Optional<Casa>>(casaService.casaSingola(idCasa), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Casa> createCasa(@RequestBody CasaModel payload) {
        return new ResponseEntity<Casa>(casaService.createCasa(payload.getCasa(), payload.getTipologia(), payload.getIndirizzo(), payload.getCap(), payload.getIdCasa(), payload.getSellerId(), payload.getImmagini()), HttpStatus.CREATED);
    }
    
    @GetMapping("/lastCase")
    public ResponseEntity<List<Casa>> getLastCase() {
        return new ResponseEntity<List<Casa>>(casaService.lastCase(), HttpStatus.OK);
    }
    
    @GetMapping("/firstCase")
    public ResponseEntity<List<Casa>> getFirstCase() {
        return new ResponseEntity<List<Casa>>(casaService.firstCase(), HttpStatus.OK);
    }

    @GetMapping("/cerca/{ricerca}/{tipologiaVendita}/{regione}/{provincia}")
    public ResponseEntity<List<Casa>> cercaCase(@PathVariable String ricerca, @PathVariable String tipologiaVendita, @PathVariable String regione, @PathVariable String provincia) {
        System.out.println("\n\nricerca:\n" + ricerca);
        System.out.println("\n\ntipologiaVendita:\n" + tipologiaVendita);
        System.out.println("\n\nregione:\n" + regione);
        System.out.println("\n\nprovincia:\n" + provincia);
        return new ResponseEntity<List<Casa>>(casaService.getCasaListByCriteria(ricerca, tipologiaVendita, regione, provincia), HttpStatus.OK);
    }


    @GetMapping("/cerca/aste")
    public ResponseEntity<List<Casa>> cercaAste() {
        System.out.println("\n\nEntro dentro ricerca aste:\n");
        return new ResponseEntity<List<Casa>>(casaService.getCaseByTipologia("asta"/*"vendita"*/), HttpStatus.OK);
    }

    @GetMapping("/cerca/vendita")
    public ResponseEntity<List<Casa>> cercaVendita() {
        System.out.println("\n\nEntro dentro ricerca aste:\n");
        return new ResponseEntity<List<Casa>>(casaService.getCaseByTipologia("vendita"/*"asta"*/), HttpStatus.OK);
    }
    
    
}
