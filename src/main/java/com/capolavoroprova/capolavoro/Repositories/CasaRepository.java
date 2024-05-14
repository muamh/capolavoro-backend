package com.capolavoroprova.capolavoro.Repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.capolavoroprova.capolavoro.Entity.Casa;

@Repository
public interface CasaRepository extends MongoRepository<Casa, ObjectId> {
    Optional<Casa> findCasaByIdCasa(String idCasa);

    @Query("{ }") // Query vuota per ottenere tutti i documenti
    List<Casa> findLast10ByOrderByDataDesc(Pageable pageable);

    @Query("{ }") // Query vuota per ottenere tutti i documenti
    List<Casa> findLast10ByOrderByDataAsc(Pageable pageable);
}
