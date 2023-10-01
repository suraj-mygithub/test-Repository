package com.hms.hmsapp.serviceImpl;

import com.hms.hmsapp.entity.Patient;
import com.hms.hmsapp.exception.ResourceNotFoundException;
import com.hms.hmsapp.payload.PatientDTO;
import com.hms.hmsapp.repository.PatientRepository;
import com.hms.hmsapp.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    PatientRepository patientRepo;

    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {

        Patient patient = mapToEntity(patientDTO);
        Patient Patient = patientRepo.save(patient);
        PatientDTO patientDTO1 = mapToDto(Patient);
        return patientDTO1;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> allPatients = patientRepo.findAll();
        List<PatientDTO> patientDTOS = allPatients.stream().map(x -> mapToDto(x)).collect(Collectors.toList());
        return patientDTOS;
    }

    @Override
    public PatientDTO getPatientById(long id) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("patient", "id", id));
        return mapToDto(patient);

        /*public PatientDTO getPatientById(long id) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("the id you entered is not valid."));
        return mapToDto(patient);*/

    }

    @Override
    public PatientDTO updatePatient(long id, PatientDTO patientDTO) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("patient", "id", id));

       // updating the patient
        patient.setName(patientDTO.getName());
        patient.setGender(patientDTO.getGender());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());

       // saving patient after updating.
        Patient Patient = patientRepo.save(patient);

        PatientDTO patientDTO1 = mapToDto(Patient);
        return patientDTO1;
    }

    @Override
    public String deletePatient(long id) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("patient", "id", id));
        patientRepo.delete(patient);
        return "patient deleted successfully.";
    }

    // conversion using modelmap


    public  Patient mapToEntity(PatientDTO patientDTO){
        Patient patient = mapper.map(patientDTO, Patient.class);
        return patient;
    }

    public  PatientDTO mapToDto(Patient Patient){
        PatientDTO PatientDTO = mapper.map(Patient, PatientDTO.class);
        return PatientDTO;
    }
}
