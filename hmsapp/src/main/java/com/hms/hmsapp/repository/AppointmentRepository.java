package com.hms.hmsapp.repository;

import com.hms.hmsapp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // custom method
    List<Appointment> findAllAppointmentsByPatientId(long patientId);

}