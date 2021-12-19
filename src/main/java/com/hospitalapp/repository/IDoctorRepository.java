package com.hospitalapp.repository;

import com.hospitalapp.exceptions.DoctorNotFoundException;
import com.hospitalapp.exceptions.HospitalNotFoundException;
import com.hospitalapp.model.Doctor;
import com.hospitalapp.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query("from Hospital h inner join h.doctors d where d.doctorName=?1")
    List<Hospital> getByDoctor(String doctorName) throws HospitalNotFoundException;
    @Query("from Hospital h inner join h.doctors d where d.specialization=?1")
    List<Hospital> getBySpecialization(String specialization) throws HospitalNotFoundException;
    @Query("from Hospital h inner join h.doctors d where d.doctorName=?1 and d.specialization=?2")
    List<Hospital> getByDoctorSpecialization(String doctorName,String specialization) throws HospitalNotFoundException;
    @Query("from Hospital h inner join h.doctors d where d.experience=?1 and d.fees=?2")
    List<Hospital> getByDoctorExperienceFees(int experience,int fees) throws HospitalNotFoundException;
    @Query("from Hospital h inner join h.doctors d where d.experience=?1 and d.totalConsults=?2")
    List<Hospital> getByexperienceConsults(int experience,int totalConsults) throws HospitalNotFoundException;
    @Query("from Hospital h inner join h.doctors d where d.doctorName=?1 and d.specialization=?2 and d.rating=?3 ")
    List<Hospital> getByDoctorSpecRating(String doctorName,String specialization,double rating) throws HospitalNotFoundException;



}
