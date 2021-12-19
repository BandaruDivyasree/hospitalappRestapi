package com.hospitalapp.service;

import com.hospitalapp.exceptions.HospitalNotFoundException;
import com.hospitalapp.model.Hospital;
import com.hospitalapp.model.Type;
import com.hospitalapp.repository.IHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements IHospitalService{
    IHospitalRepository hospitalRepository;
    @Autowired
    public void setHospitalRepository(IHospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public void updateHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospital(int hospitalId) {
       hospitalRepository.deleteById(hospitalId);
    }

    @Override
    public Hospital getById(int hospitalId) throws HospitalNotFoundException {
        return hospitalRepository.findById(hospitalId)
                .orElseThrow(()->new HospitalNotFoundException("Invalid Id"));
    }

    @Override
    public List<Hospital> getAll() {

        return hospitalRepository.findAll();
    }

    @Override
    public List<Hospital> getByHospitalName(String hospitalName) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByHospitalName(hospitalName);
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("hospital name not found");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByHospitalStreetName(String streetName) throws HospitalNotFoundException {
        List<Hospital> hospitalList= hospitalRepository.getByHospitalStreetName(streetName);
        if(hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Street not found");

        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByHospitalLoc(String hospitalName, String location) throws HospitalNotFoundException {
        List<Hospital> hospitalList = hospitalRepository.getByHospitalLoc(hospitalName, location);
        if (hospitalList.isEmpty()) {
            throw new HospitalNotFoundException("Hospital with this location not found");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByHospitalDoctor(String hospitalName, String doctorName) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByHospitalDoctor(hospitalName, doctorName);
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Hospital with this doctor not found");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByHospitalPatient(String hospitalName, String patientName) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByHospitalPatient(hospitalName,patientName);
        if(hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Hospital with this patient not found");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByHosPatType(String hospitalName, String patientName, String type) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByHosPatType(hospitalName,patientName,Type.valueOf(type));
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Invalid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByPatient(String patientName) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByPatient(patientName);
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Invalid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByTypePatient(String type, String patientName) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByTypePatient(Type.valueOf(type),patientName);
        if(hospitalList.isEmpty()){
            throw new HospitalNotFoundException("InValid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByPatientAge(String patientName, int age) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByPatientAge(patientName,age);
        if(hospitalList.isEmpty()){
            throw new HospitalNotFoundException("InValid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByPatientGender(String patientName, String gender) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByPatientGender(patientName, gender);
        if(hospitalList.isEmpty()){
            throw new HospitalNotFoundException("InValid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByNameAgeGender(String patientName, int age, String gender) throws HospitalNotFoundException {
        List<Hospital> hospitalList=hospitalRepository.getByNameAgeGender(patientName,age,gender);
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Invalid");
        }
        return hospitalList;
    }
}
