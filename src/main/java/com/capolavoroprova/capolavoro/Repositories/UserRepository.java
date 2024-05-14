package com.capolavoroprova.capolavoro.Repositories;

import com.capolavoroprova.capolavoro.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

}

