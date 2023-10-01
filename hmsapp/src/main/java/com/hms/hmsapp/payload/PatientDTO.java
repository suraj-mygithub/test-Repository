package com.hms.hmsapp.payload;

import lombok.Data;

@Data
public class PatientDTO {

    private Long id;
    private String name;
    private String dateOfBirth;
    private String gender;

}
