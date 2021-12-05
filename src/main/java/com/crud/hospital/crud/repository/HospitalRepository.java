package com.crud.hospital.crud.repository;

import com.crud.hospital.crud.domain.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {
    List<Hospital> findByNameLikeIgnoreCase(String name);
}
