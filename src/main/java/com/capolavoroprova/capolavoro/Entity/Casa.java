package com.capolavoroprova.capolavoro.Entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.BsonTimestamp;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "case")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Casa {
    @Id
    private ObjectId id;
    private String casa;
    private List<String> tipologia;
    private String indirizzo;
    private String provincia;
    private String provincia_sigla;
    private String regione;
    private String regione_sigla;
    private int cap;
    private String idCasa;
    private int sellerId;
    private List<String> immagini;
    private BsonTimestamp ora_inizio;
    private BsonTimestamp ora_fine;
    private Date data_inizio;
    private Date data_fine;
    private String descrizione;
    private double prezzo;
    private String tipo_vendita;

    public Casa(String casa, List<String> tipologia, String indirizzo, String cap, String idCasa, String sellerId, List<String> immagini){
        this.casa = casa;
        this.tipologia = tipologia;
        this.indirizzo = indirizzo;
        this.cap = Integer.parseInt(cap);
        this.idCasa = idCasa;
        this.sellerId = Integer.parseInt(sellerId);
        this.immagini = immagini;
    }
}
