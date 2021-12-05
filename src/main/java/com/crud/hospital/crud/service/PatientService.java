package com.crud.hospital.crud.service;

import com.crud.hospital.crud.domain.Patients;
import com.crud.hospital.crud.repository.PatientRepository;
import com.crud.hospital.crud.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public Patients findById(String id) {
        Optional<Patients> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado!"));
    }
    public Patients update(Patients obj) {
        return repo.save(obj);
    }
}
