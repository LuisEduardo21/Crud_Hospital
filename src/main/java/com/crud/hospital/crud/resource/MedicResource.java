package com.crud.hospital.crud.resource;

import com.crud.hospital.crud.constant.Constant;
import com.crud.hospital.crud.domain.Hospital;
import com.crud.hospital.crud.domain.Medic;
import com.crud.hospital.crud.resource.exception.ResourceNotFoundException;
import com.crud.hospital.crud.service.HospitalService;
import com.crud.hospital.crud.service.MedicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200") // permissão para o Angular
@RestController
@RequestMapping(path = Constant.V1Path)
public class MedicResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicResource.class);

    @Autowired
    private MedicService service;

    @Autowired
    private HospitalService hospitalService;

    @GetMapping(path = "medicos")
    public ResponseEntity<List<Medic>> findMedic(@PathVariable String hospital_id) {
        try {
            Hospital obj = hospitalService.findById(hospital_id);
            List<Medic> medicList = obj.getId();
            if (medicList != null) {
                return ResponseEntity.ok(medicList);
            }
            throw new ResourceNotFoundException("Não tem medico");
        } catch (Exception e) {
            LOGGER.error("findPatients - Error with message: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "medicos/{medicoId}")
    public ResponseEntity<Medic> findMedicById(@PathVariable String hospital_id, @PathVariable String medicId) {
        try {
            Medic medic = service.findById(medicId);
            return ResponseEntity.ok().body(medic);
        } catch (Exception e) {
            LOGGER.error("findPatientById - Error with message: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping(path = "medicos/{medicoId}")
    public ResponseEntity<Medic> updateMedic(@PathVariable("hospital_id") String idHospital, @PathVariable String medictId,
                                                  @RequestBody Medic medic) {
        try {
            Medic m = service.findById(medictId);
            m.setName(medic.getName());
            m.setCPF(medic.getCPF());
            return ResponseEntity.ok(service.update(m));
        } catch (Exception e) {
            LOGGER.error("updateMedic - Error with message: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
