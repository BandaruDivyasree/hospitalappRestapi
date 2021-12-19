package com.hospitalapp.service;

import com.hospitalapp.exceptions.HospitalNotFoundException;
import com.hospitalapp.model.Hospital;

import javax.persistence.metamodel.ListAttribute;
import java.util.List;

public interface IHospitalService {

    Hospital addHospital(Hospital hospital);
    void updateHospital(Hospital hospital);
    void deleteHospital(int hospitalId);
    Hospital getById(int hospitalId) throws HospitalNotFoundException;

    List<Hospital> getAll();
    List<Hospital> getByHospitalName(String hospitalName) throws HospitalNotFoundException;
    List<Hospital> getByHospitalStreetName(String streetName) throws HospitalNotFoundException;
    List<Hospital> getByHospitalLoc(String hospitalName,String location)throws HospitalNotFoundException;
    List<Hospital> getByHospitalDoctor(String hospitalName,String doctorName) throws  HospitalNotFoundException;
    List<Hospital> getByHospitalPatient(String hospitalName,String patientName) throws HospitalNotFoundException;
    List<Hospital> getByHosPatType(String hospitalName,String patientName,String type) throws HospitalNotFoundException;

    List<Hospital> getByPatient(String patientName)throws HospitalNotFoundException;

    List<Hospital> getByTypePatient(String type,String patientName) throws HospitalNotFoundException;
    List<Hospital> getByPatientAge(String patientName,int age) throws HospitalNotFoundException;
    List<Hospital> getByPatientGender(String patientName,String gender) throws HospitalNotFoundException;
    List<Hospital> getByNameAgeGender(String patientName,int age,String gender) throws HospitalNotFoundException;


}
