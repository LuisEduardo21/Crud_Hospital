package com.crud.hospital.crud.resource;


import com.crud.hospital.crud.constant.Constant;
import com.crud.hospital.crud.domain.Hospital;
import com.crud.hospital.crud.domain.Patients;
import com.crud.hospital.crud.resource.exception.ResourceNotFoundException;
import com.crud.hospital.crud.service.HospitalService;
import com.crud.hospital.crud.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = Constant.V1Path)
public class PatientResources {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicResource.class);

    @Autowired
    private PatientService service;

    @Autowired
    private HospitalService hospitalService;

    @GetMapping(path = "pacientes")
    public ResponseEntity<List<Patients>> findPatients(@PathVariable String hospital_id) {
        try {
            Hospital obj = hospitalService.findById(hospital_id);
            List<Patients> patientList = obj.getPatients();
            if (patientList != null) {
                return ResponseEntity.ok(patientList);
            }
            throw new ResourceNotFoundException("Não tem Paciente");
        } catch (Exception e) {
            LOGGER.error("findPatients - Error with message: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "pacientes/{patientId}")
    public ResponseEntity<Patients> findPatientById(@PathVariable String hospital_id, @PathVariable String patientId) {
        try {
            Patients patient = service.findById(patientId);
            return ResponseEntity.ok().body(patient);
        } catch (Exception e) {
            LOGGER.error("findPatientById - Error with message: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping(path = "pacientes/{patientId}")
    public ResponseEntity<Patients> updatePatient(@PathVariable("hospital_id") String idHospital, @PathVariable String patientId,
                                                  @RequestBody Patients patient) {
        try {
            Patients p = service.findById(patientId);
            p.setName(patient.getName());
            p.setCpf(patient.getCpf());
            p.setBirthDate(patient.getBirthDate());
            p.setGender(patient.getGender());
            return ResponseEntity.ok(service.update(p));
        } catch (Exception e) {
            LOGGER.error("updatePatient - Error with message: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

}
