package com.crud.hospital.crud.resource;


import com.crud.hospital.crud.constant.Constant;
import com.crud.hospital.crud.domain.Hospital;
import com.crud.hospital.crud.dto.HospitalDTO;
import com.crud.hospital.crud.service.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = Constant.V1)
public class HospitalResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicResource.class);

    @Autowired
    private HospitalService service;

    @GetMapping()
    public ResponseEntity<List<HospitalDTO>> findAll() {
        try {
            List<Hospital> list = service.findAll();
            List<HospitalDTO> listDTO = list.stream().map(x -> new HospitalDTO(x)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listDTO);
        } catch (Exception e) {
            LOGGER.error("findAllHospital - Error with message: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/{hospital_id}")
    public ResponseEntity<HospitalDTO> findById(@PathVariable String hospital_id) {
        try {
            Hospital obj = service.findById(hospital_id);

            HospitalDTO hospitalDTO = new HospitalDTO(obj);

            return Optional.ofNullable(hospitalDTO).map(hospitalResponse -> ResponseEntity.ok().body(hospitalResponse))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            LOGGER.error("findHospitalById - Error with message: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

}
