package com.crud.hospital.crud.repository;

import com.crud.hospital.crud.domain.Patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patients, String> {
}
