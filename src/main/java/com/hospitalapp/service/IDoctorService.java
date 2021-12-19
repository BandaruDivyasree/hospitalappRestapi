package com.hospitalapp.service;

import com.hospitalapp.exceptions.DoctorNotFoundException;
import com.hospitalapp.exceptions.HospitalNotFoundException;
import com.hospitalapp.model.Doctor;
import com.hospitalapp.model.Hospital;

import java.util.List;

public interface IDoctorService {
    Doctor addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    Doctor getById(int doctorId) throws DoctorNotFoundException;

    List<Hospital> getByDoctor(String doctorName) throws HospitalNotFoundException;
    List<Hospital> getBySpecialization(String specialization) throws HospitalNotFoundException;
    List<Hospital> getByDoctorSpecialization(String doctorName,String specialization) throws  HospitalNotFoundException;
    List<Hospital> getByDoctorExperienceFees(int experience,int fees) throws HospitalNotFoundException;
    List<Hospital> getByexperienceConsults(int experience,int totalConsults) throws HospitalNotFoundException;
    List<Hospital> getByDoctorSpecRating(String doctorName,String specialization,double rating) throws HospitalNotFoundException;

}
