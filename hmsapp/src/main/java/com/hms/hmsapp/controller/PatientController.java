package com.hms.hmsapp.controller;

import com.hms.hmsapp.payload.PatientDTO;
import com.hms.hmsapp.repository.PatientRepository;
import com.hms.hmsapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patient")
public class PatientController {

    @Autowired
PatientService patientService;


@PostMapping
    public ResponseEntity<PatientDTO> savePatients(@RequestBody PatientDTO patientDTO){
    PatientDTO patientDTO1 = patientService.savePatient(patientDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
    }

@GetMapping
    public List<PatientDTO> getAllPatients(){
    List<PatientDTO> allPatients = patientService.getAllPatients();
    return allPatients;
}
@GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable(name="id") long id){
    PatientDTO patientDTO = patientService.getPatientById(id);
    return new ResponseEntity<>(patientDTO,HttpStatus.OK);



}
@PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable(name="id") long id, @RequestBody PatientDTO patientDTO){
    PatientDTO patientDTO1 = patientService.updatePatient(id, patientDTO);
    return new ResponseEntity<>(patientDTO1,HttpStatus.CREATED);
}

@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name="id") long id){
    String msg = patientService.deletePatient(id);

    return new ResponseEntity<>(msg,HttpStatus.OK);
}






}
