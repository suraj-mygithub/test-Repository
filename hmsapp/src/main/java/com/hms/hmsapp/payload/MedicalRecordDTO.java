package com.hms.hmsapp.payload;

import lombok.Data;

@Data
public class MedicalRecordDTO {

    private Long id;
    private String medicalHistory;
    private String diagnosis;

}
