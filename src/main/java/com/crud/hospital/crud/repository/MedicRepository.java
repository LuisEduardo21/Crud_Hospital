package com.crud.hospital.crud.repository;

import com.crud.hospital.crud.domain.Medic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicRepository extends MongoRepository<Medic, String> {

}
