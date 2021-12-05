package com.crud.hospital.crud.service;

import com.crud.hospital.crud.domain.Medic;
import com.crud.hospital.crud.domain.Patients;
import com.crud.hospital.crud.dto.MedicDTO;
import com.crud.hospital.crud.repository.MedicRepository;
import com.crud.hospital.crud.service.exception.ObjectNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicService {

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private  HospitalService hospitalService;

    public Medic findById(String id) {
        Optional<Medic> obj = medicRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Medico não encontrado!"));
    }
    public Medic update(Medic obj) {
        return medicRepository.save(obj);
    }

}
