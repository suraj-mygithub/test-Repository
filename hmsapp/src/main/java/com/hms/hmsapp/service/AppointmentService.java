package com.hms.hmsapp.service;

import com.hms.hmsapp.entity.Appointment;
import com.hms.hmsapp.payload.AppointmentDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AppointmentService {

    public AppointmentDTO bookAppointment(long patientId,AppointmentDTO appointmentDto);

    List<AppointmentDTO> getAllAppointment();

   public List<AppointmentDTO> getAllAppointmentByPatientId(long patientId);

    AppointmentDTO updateAppointment(long patientId, long appointmentId,@RequestBody AppointmentDTO appointmentDTO);

    String deleteAppointment(long patientId, long appointmentId);
}
