package com.supra.entretien.ClientRegister.repository;

import com.supra.entretien.ClientRegister.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

}
