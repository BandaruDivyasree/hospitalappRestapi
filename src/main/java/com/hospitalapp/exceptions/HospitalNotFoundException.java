package com.hospitalapp.exceptions;

public class HospitalNotFoundException extends RuntimeException{
    public HospitalNotFoundException() {
        super();
    }

    public HospitalNotFoundException(String message) {
        super(message);
    }
}
