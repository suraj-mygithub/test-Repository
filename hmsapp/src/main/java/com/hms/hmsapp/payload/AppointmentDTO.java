package com.hms.hmsapp.payload;

import lombok.Data;

import java.util.Date;
@Data
public class AppointmentDTO {

    private Long id;
    private Date appointmentDate;
    private String reasonForVisit;
    private String appointmentStatus;

}

