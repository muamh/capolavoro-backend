package com.capolavoroprova.capolavoro.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.capolavoroprova.capolavoro.Entity.Casa;
import com.capolavoroprova.capolavoro.Entity.Venditore;
import com.capolavoroprova.capolavoro.Repositories.VenditoreRepository;

@Service
public class VenditoreService {
    @Autowired
    private VenditoreRepository venditoreRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Venditore> allVenditori(){
        return venditoreRepository.findAll();
    }

    public Venditore createVenditore(String nome, String cognome, int idVenditore, String idCasa){
        Venditore venditore = venditoreRepository.insert(new Venditore(nome, cognome, idVenditore));

        mongoTemplate.update(Casa.class)
            .matching(Criteria.where("idCasa").is(idCasa))
            .apply(new Update().set("sellerId", venditore.getIdVenditore()))
            .first();
        return venditore;
    }
}
