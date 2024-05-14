package com.capolavoroprova.capolavoro.Services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.capolavoroprova.capolavoro.Entity.Casa;
import com.capolavoroprova.capolavoro.Entity.Venditore;
import com.capolavoroprova.capolavoro.Repositories.CasaRepository;

@Service
public class CasaService {
    @Autowired//Istanzia automaticamente casaRepository
    private CasaRepository casaRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Casa> allCase(){
        return casaRepository.findAll();
    }

    public List<Casa> lastCase(){
        Pageable pageable = PageRequest.of(0, 8, Sort.by("idCasa").descending());
        return casaRepository.findLast10ByOrderByDataDesc(pageable);
    }

    public List<Casa> firstCase(){
        Pageable pageable = PageRequest.of(0, 8, Sort.by("idCasa").ascending());
        return casaRepository.findLast10ByOrderByDataAsc(pageable);
    }

    public Optional<Casa> casaSingola(ObjectId id){//In caso trova la casa va bene la ritorna allora può anche tornare null
        return casaRepository.findById(id);
    }

    public Optional<Casa> casaSingola(String idCasa){
        return casaRepository.findCasaByIdCasa(idCasa);
    }

    public Casa createCasa(String casaName, List<String> tipologia, String indirizzo, String cap, String idCasa, String sellerId, List<String> immagini){
        Casa casa = casaRepository.insert(new Casa(casaName, tipologia, indirizzo, cap, idCasa, sellerId, immagini));

        mongoTemplate.update(Venditore.class)
            .matching(Criteria.where("idVenditore").is(Integer.parseInt(sellerId)))
            .apply(new Update().push("caseId").value(casa.getIdCasa()))
            .first();
        return casa;
    }

    public List<Casa> getCasaListByCriteria(String ricerca, String tipologiaVendita, String regione, String provincia) {
        List<String> paroleRicerca = Arrays.asList(ricerca.split("\\s+"));
        Criteria[] criteri = new Criteria[paroleRicerca.size()];

        for (int i = 0; i < paroleRicerca.size(); i++) {
            criteri[i] = new Criteria().orOperator(
                    Criteria.where("casa").regex(paroleRicerca.get(i), "i"),
                    Criteria.where("indirizzo").regex(paroleRicerca.get(i), "i"),
                    Criteria.where("tipologia").regex(paroleRicerca.get(i), "i"),
                    Criteria.where("cap").regex(paroleRicerca.get(i), "i")
            );
        }

        Criteria ricercaComplessiva = new Criteria().andOperator(criteri);
        List<Casa> caseTrovate = mongoTemplate.find(Query.query(ricercaComplessiva), Casa.class);

        return caseTrovate;
    }

    public List<Casa> getCaseByTipologia(String tipologia) {
        Criteria[] criteri = new Criteria[1];

        criteri[0] = new Criteria().andOperator(
                Criteria.where("tipo_vendita").regex(tipologia, "i")
        );

        Criteria ricercaComplessiva = new Criteria().andOperator(criteri);
        List<Casa> caseTrovate = mongoTemplate.find(Query.query(ricercaComplessiva), Casa.class);

        return caseTrovate;
    }

}
