package com.hms.hmsapp.repository;

import com.hms.hmsapp.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    // You can add custom query methods here if needed
}
