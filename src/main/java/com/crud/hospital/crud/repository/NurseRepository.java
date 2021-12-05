package com.crud.hospital.crud.repository;

import com.crud.hospital.crud.domain.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends MongoRepository<Nurse, String> {
}
