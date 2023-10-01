package com.hms.hmsapp.serviceImpl;

import com.hms.hmsapp.entity.Appointment;
import com.hms.hmsapp.entity.Patient;
import com.hms.hmsapp.exception.ResourceNotFoundException;
import com.hms.hmsapp.payload.AppointmentDTO;
import com.hms.hmsapp.repository.AppointmentRepository;
import com.hms.hmsapp.repository.PatientRepository;
import com.hms.hmsapp.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    ModelMapper mapper;
    @Autowired
    AppointmentRepository appointmentRepo;
    @Autowired
    PatientRepository patientRepo;
    @Override
    public AppointmentDTO bookAppointment(long patientId,AppointmentDTO appointmentDto) {
        Appointment appointment = mapToEntity(appointmentDto);
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("patient", "id", patientId));
        appointment.setPatient(patient);
        Appointment appointment1= appointmentRepo.save(appointment);
        AppointmentDTO appointmentDTO = mapToDto(appointment1);
        return appointmentDTO;
    }

    @Override
    public List<AppointmentDTO> getAllAppointment() {
        List<Appointment> allAppointment = appointmentRepo.findAll();
        List<AppointmentDTO> allAppointments = allAppointment.stream().map(x -> mapToDto(x)).collect(Collectors.toList());
        return allAppointments;
    }

    @Override
    public List<AppointmentDTO> getAllAppointmentByPatientId(long patientId) {
        List<Appointment> allAppointmentsByPatientId = appointmentRepo.findAllAppointmentsByPatientId(patientId);
        List<AppointmentDTO> appointmentDTOS = allAppointmentsByPatientId.stream().map(x -> mapToDto(x)).collect(Collectors.toList());
        return appointmentDTOS;
    }

    @Override
    public AppointmentDTO updateAppointment(long patientId, long appointmentId,@RequestBody AppointmentDTO appointmentDTO) {
        // direct update of child member(appointment) not allowed. so firstly checking patents(patient) & child(appointment) is available or not then we verify weather child(appointment) belongs to parents or not then we update child(appointment).
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("patient", "id", patientId));
        Appointment appointment = appointmentRepo.findById(appointmentId).orElseThrow(() -> new ResourceNotFoundException("patient", "id", appointmentId));

        appointment.setReasonForVisit(appointmentDTO.getReasonForVisit());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setAppointmentStatus(appointmentDTO.getAppointmentStatus());

        Appointment saved = appointmentRepo.save(appointment);
        AppointmentDTO appointmentDTO1 = mapToDto(saved);
        return appointmentDTO1;
    }

    @Override
    public String deleteAppointment(long patientId, long appointmentId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("patient", "id", patientId));
        Appointment appointment = appointmentRepo.findById(appointmentId).orElseThrow(() -> new ResourceNotFoundException("patient", "id", appointmentId));

         appointmentRepo.delete(appointment);

        return  new String("APPOINTMENT WITH GIVEN ID DELETED SUCCESSFULLY.");
    }






    //DTO to Entity
    public Appointment mapToEntity(AppointmentDTO appointmentDTO){
        Appointment appointment = mapper.map(appointmentDTO, Appointment.class);
        return appointment;
    }
    // Entity to DTO
    public  AppointmentDTO mapToDto(Appointment appointment){
        AppointmentDTO appointmentDTO = mapper.map(appointment, AppointmentDTO.class);
        return appointmentDTO;
    }


}
