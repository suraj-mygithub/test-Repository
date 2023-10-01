package com.hms.hmsapp.controller;

import com.hms.hmsapp.payload.AppointmentDTO;
import com.hms.hmsapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")

public class AppointmentController {
@Autowired
    AppointmentService appointmentService;

@PostMapping("/patient/{patientId}/appointment")
    public ResponseEntity<?> bookAppointment(@PathVariable(value="patientId") long patientId, @RequestBody AppointmentDTO appointmentDto){
    AppointmentDTO appointmentDTO = appointmentService.bookAppointment(patientId,appointmentDto);
        return new ResponseEntity<>(appointmentDTO, HttpStatus.CREATED);
    }
@GetMapping("/patient/appointment")
    public List<AppointmentDTO> getAllAppointment(){
    List<AppointmentDTO> allAppointments = appointmentService.getAllAppointment();
    return allAppointments;
}
@GetMapping("/patient/{patientId}/appointment")
     public List<AppointmentDTO> getAppointmentById(@PathVariable(value = "patientId") long patientId){
    List<AppointmentDTO> allAppointmentByPatientId = appointmentService.getAllAppointmentByPatientId(patientId);
    return allAppointmentByPatientId;
}
@PutMapping("/patient/{patientId}/appointment/{appointmentId}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable(value="patientId") long patientId, @PathVariable(value="appointmentId") long appointmentId, @RequestBody AppointmentDTO appointmentDTO){
    AppointmentDTO appointmentDTO1 = appointmentService.updateAppointment(patientId, appointmentId, appointmentDTO);
    return new ResponseEntity<>(appointmentDTO1,HttpStatus.OK);
}
@DeleteMapping("/patient/{patientId}/appointment/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable(value="patientId") long patientId, @PathVariable(value="appointmentId") long appointmentId){
    String msg = appointmentService.deleteAppointment(patientId, appointmentId);
    return new ResponseEntity<>(msg,HttpStatus.OK);
}





}
