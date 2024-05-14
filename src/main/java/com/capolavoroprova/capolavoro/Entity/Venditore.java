package com.capolavoroprova.capolavoro.Entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "venditori")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venditore {
    @Id
    private ObjectId id;
    private String nome;
    private String cognome;
    private int idVenditore;
    private List<String> caseId;

    public Venditore(String nome, String cognome, int idVenditore){
        this.nome = nome;
        this.cognome = cognome;
        this.idVenditore = idVenditore;
    }
}
