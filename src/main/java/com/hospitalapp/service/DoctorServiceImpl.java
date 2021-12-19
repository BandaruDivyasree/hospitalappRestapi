package com.hospitalapp.service;

import com.hospitalapp.exceptions.DoctorNotFoundException;
import com.hospitalapp.exceptions.HospitalNotFoundException;
import com.hospitalapp.model.Doctor;
import com.hospitalapp.model.Hospital;
import com.hospitalapp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService{
    @Autowired
    IDoctorRepository doctorRepository;

    public void setDoctorRepository(IDoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @Override
    public Doctor addDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);

    }

    @Override
    public Doctor getById(int doctorId) throws DoctorNotFoundException {
        return doctorRepository.findById(doctorId).get();
    }

    @Override
    public List<Hospital> getByDoctor(String doctorName) throws HospitalNotFoundException {
        List<Hospital> hospitalList=doctorRepository.getByDoctor(doctorName);
        if(hospitalList.isEmpty()){
            throw new HospitalNotFoundException("InValid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getBySpecialization(String specialization) throws HospitalNotFoundException {
        List<Hospital> hospitalList=doctorRepository.getBySpecialization(specialization);
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Invalid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByDoctorSpecialization(String doctorName, String specialization) throws HospitalNotFoundException {
        List<Hospital> hospitalList=doctorRepository.getByDoctorSpecialization(doctorName, specialization);
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Invalid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByDoctorExperienceFees(int experience, int fees) throws HospitalNotFoundException {
        List<Hospital> hospitalList=doctorRepository.getByDoctorExperienceFees(experience, fees);
        if(hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Invalid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByexperienceConsults(int experience, int totalConsults) throws HospitalNotFoundException {
        List<Hospital> hospitalList=doctorRepository.getByexperienceConsults(experience, totalConsults);
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Invalid");
        }
        return hospitalList;
    }

    @Override
    public List<Hospital> getByDoctorSpecRating(String doctorName, String specialization, double rating) throws HospitalNotFoundException {
        List<Hospital> hospitalList=doctorRepository.getByDoctorSpecRating(doctorName,specialization,rating);
        if (hospitalList.isEmpty()){
            throw new HospitalNotFoundException("Invalid");
        }
        return hospitalList;
    }
}
