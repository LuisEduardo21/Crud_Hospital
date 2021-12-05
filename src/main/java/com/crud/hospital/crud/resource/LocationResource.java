package com.crud.hospital.crud.resource;

import com.crud.hospital.crud.constant.Constant;
import com.crud.hospital.crud.dto.HospitalDTO;
import com.crud.hospital.crud.dto.LocationDTO;
import com.crud.hospital.crud.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = Constant.V1Path)
public class LocationResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationResource.class);
    @Autowired
    private LocationService locationService;

    @GetMapping(path = "/proximidades")
    public ResponseEntity<List<LocationDTO>> findLocationNearHospitalBy(@PathVariable String hospital_id) {
        try {
            List<LocationDTO> locations = locationService.findLocationNearHospitalBy(hospital_id);

            return Optional.ofNullable(locations).map(productReponse -> ResponseEntity.ok().body(productReponse))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception ex) {
            LOGGER.error("findLocationNearHospitalBy - Handling error with message: {}", ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/hospitaisProximos")
    public ResponseEntity<List<HospitalDTO>> findHospitalNearHospitalBy(@PathVariable String hospital_id, @RequestParam Double raio) {
        try {
            List<HospitalDTO> locations = locationService.findHospitalNearHospitalBy(hospital_id, raio);

            return Optional.ofNullable(locations).map(productReponse -> ResponseEntity.ok().body(productReponse))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception ex) {
            LOGGER.error("findHospitalNearHospitalBy - Handling error with message: {}", ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
