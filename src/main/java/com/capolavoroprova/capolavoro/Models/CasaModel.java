package com.capolavoroprova.capolavoro.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasaModel {
    private String casa;
    private List<String> tipologia;
    private String indirizzo;
    private String cap;
    private String idCasa;
    private String sellerId;
    private List<String> immagini;
}
