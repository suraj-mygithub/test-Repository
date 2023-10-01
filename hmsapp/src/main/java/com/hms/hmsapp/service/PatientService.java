package com.hms.hmsapp.service;

import com.hms.hmsapp.entity.Patient;
import com.hms.hmsapp.payload.PatientDTO;

import java.util.List;

public interface PatientService {

    public PatientDTO savePatient(PatientDTO patientDTO);

    public List<PatientDTO> getAllPatients();

   public PatientDTO getPatientById(long id);

    PatientDTO updatePatient(long id, PatientDTO patientDTO);

   public String deletePatient(long id);
}
