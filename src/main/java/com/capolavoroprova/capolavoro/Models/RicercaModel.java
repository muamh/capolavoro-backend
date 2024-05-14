package com.capolavoroprova.capolavoro.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RicercaModel {
    private String ricerca;
    private String tipologiaVendita;
    private String regione;
    private String provincia;
}
