package com.hms.hmsapp.repository;

import com.hms.hmsapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // You can add custom query methods here if needed
}
