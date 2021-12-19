package com.hospitalapp.repository;

import com.hospitalapp.exceptions.HospitalNotFoundException;
import com.hospitalapp.model.Hospital;
import com.hospitalapp.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHospitalRepository extends JpaRepository<Hospital,Integer> {

   List<Hospital> getByHospitalName(String hospitalName) throws HospitalNotFoundException;
   @Query("from Hospital h inner join h.hAddress a where a.streetName=?1")
   List<Hospital> getByHospitalStreetName(String streetName) throws HospitalNotFoundException;

   @Query("from Hospital h inner join h.hAddress a where h.hospitalName=?1 and a.location=?2")
   List<Hospital> getByHospitalLoc(String hospitalName,String location)throws HospitalNotFoundException;

   @Query("from Hospital h inner join h.doctors d where h.hospitalName=?1 and d.doctorName=?2")
   List<Hospital> getByHospitalDoctor(String hospitalName,String doctorName) throws  HospitalNotFoundException;

   @Query("from Hospital h inner join h.patients p where h.hospitalName=?1 and p.patientName=?2")
   List<Hospital> getByHospitalPatient(String hospitalName, String patientName) throws HospitalNotFoundException;

   @Query("from Hospital h inner join h.patients p  where h.hospitalName=?1 and p.patientName=?2 and p.type=?3")
   List<Hospital> getByHosPatType(String hospitalName, String patientName, Type type) throws HospitalNotFoundException;

   @Query("from Hospital h inner join h.patients p where p.patientName=?1")
   List<Hospital> getByPatient(String patientName)throws HospitalNotFoundException;

   @Query("from Hospital h inner join h.patients p where p.type=?1 and p.patientName=?2")
   List<Hospital> getByTypePatient(Type type,String patientName) throws HospitalNotFoundException;

   @Query("from Hospital h inner join h.patients p where p.patientName=?1 and p.age=?2")
   List<Hospital> getByPatientAge(String patientName,int age) throws HospitalNotFoundException;

   @Query("from Hospital h inner join h.patients p where p.patientName=?1 and p.gender=?2 ")
   List<Hospital> getByPatientGender(String patientName,String gender) throws HospitalNotFoundException;

   @Query("from Hospital h inner join h.patients p where p.patientName=?1 and p.age=?2 and p.gender=?3")
   List<Hospital> getByNameAgeGender(String patientName,int age,String gender) throws HospitalNotFoundException;



}
