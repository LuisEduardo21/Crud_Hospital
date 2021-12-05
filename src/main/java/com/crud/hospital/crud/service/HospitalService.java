package com.crud.hospital.crud.service;

import com.crud.hospital.crud.domain.Hospital;
import com.crud.hospital.crud.domain.Location;
import com.crud.hospital.crud.domain.Medic;
import com.crud.hospital.crud.dto.HospitalDTO;
import com.crud.hospital.crud.repository.HospitalRepository;
import com.crud.hospital.crud.repository.MedicRepository;
import com.crud.hospital.crud.repository.NurseRepository;
import com.crud.hospital.crud.repository.PatientRepository;
import com.crud.hospital.crud.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository repository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private LocationService locationService;

    public List<Hospital> findAll() {
        return repository.findAll();
    }

    public Hospital findById(String hospital_id) {
        Optional<Hospital> obj = repository.findById(hospital_id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Hospital não encontrado! ID:" + hospital_id));
    }

    public Hospital insert(Hospital obj) {
        Location location = locationService.insertLocationByHospital(obj);
        obj.setLocation(location);

        return repository.insert(obj);
    }

    public void delete(String hospital_id) {
        findById(hospital_id);
        repository.deleteById(hospital_id);
    }

    public Hospital update(Hospital obj) {
        Hospital newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Hospital newObj, Hospital obj) {
        newObj.setName(obj.getName());
        newObj.setAddress(obj.getAddress());

    }

    public Hospital fromDTO(HospitalDTO objDTO) {
        if (objDTO.getId() == null) {
            return new Hospital(objDTO.getId(), objDTO.getName(), objDTO.getAddress());
        }
        return findById(objDTO.getId());
    }

    public HospitalDTO convertToDTO(Hospital model) {
        return new HospitalDTO(model);
    }

    public List<HospitalDTO> convertToDTOs(List<Hospital> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private String findHospitalProximoComEstoque(String hospitalId, Medic medic) {

        List<HospitalDTO> hospitaisDTO = locationService.findHospitalNearHospitalBy(hospitalId, null);


        List<Hospital> hospitais = hospitaisDTO.stream()
                .map(h -> fromDTO(h))
                .collect(Collectors.toList());


        return "sucess";
    }



}
