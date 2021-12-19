package com.hospitalapp.exceptions;

public class DoctorNotFoundException extends  RuntimeException{

    public DoctorNotFoundException() {
        super();
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
