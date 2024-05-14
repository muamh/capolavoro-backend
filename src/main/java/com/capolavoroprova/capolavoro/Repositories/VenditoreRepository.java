package com.capolavoroprova.capolavoro.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capolavoroprova.capolavoro.Entity.Venditore;

@Repository
public interface VenditoreRepository extends MongoRepository<Venditore, ObjectId>{
    
}
