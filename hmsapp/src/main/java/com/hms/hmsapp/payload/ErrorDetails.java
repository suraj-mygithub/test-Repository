package com.hms.hmsapp.payload;

import java.util.Date;

public class ErrorDetails{
    private Date timestamp;
    private String message;
    private String details;


// instead of Setter method , i am using constructor just to prastic constructor.
    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
