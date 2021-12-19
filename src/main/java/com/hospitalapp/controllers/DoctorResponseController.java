package com.hospitalapp.controllers;

import com.hospitalapp.model.Doctor;
import com.hospitalapp.model.Hospital;
import com.hospitalapp.service.IDoctorService;
import com.hospitalapp.service.IHospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor-response-api")
public class DoctorResponseController {

    private IDoctorService doctorService;
    private Logger logger = LoggerFactory.getLogger(DoctorResponseController.class);
    @Autowired
    public void setDoctorService(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        logger.debug("inside Add Doctor method");
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Adding new Doctor");
        Doctor ndoctor=doctorService.addDoctor(doctor);
        logger.info("Doctor Added"+ndoctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(ndoctor);
    }
    @PutMapping("/doctors")
    public ResponseEntity<Void> updateHospital(@RequestBody Doctor doctor) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Updating a Doctor");
        doctorService.updateDoctor(doctor);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }
    @DeleteMapping("/hospitals/doctorId/{doctorId}")
    public ResponseEntity <String> deleteDoctor(@PathVariable("doctorId") int doctorId) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","deleting a Doctor");
        doctorService.getById(doctorId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }
    @GetMapping("/hospitals/doctorName/{doctorName}")
    public ResponseEntity<List<Hospital>> getByDoctor(@PathVariable("doctorName") String doctorName){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Doctor Name ");
       List<Hospital> hospitalList= doctorService.getByDoctor(doctorName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);

    }
    @GetMapping("/hospitals/specializations/{specialization}")
    public ResponseEntity<List<Hospital>> getBySpecialization(@PathVariable("specialization") String specialization){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Doctor specialization");
        List<Hospital> hospitalList= doctorService.getBySpecialization(specialization);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/doctorNames/{doctorName}/specializations/{specialization}")
    public ResponseEntity<List<Hospital>> getByDoctorSpecialization(@PathVariable("doctorName") String doctorName,@PathVariable("specialization") String specialization){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","DoctorName specialization");
        List<Hospital> hospitalList= doctorService.getByDoctorSpecialization(doctorName, specialization);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/experiences/{experience}/fees/{fees}")
    public ResponseEntity<List<Hospital>> getByDoctorExperienceFees(@PathVariable("experience") int experience,@PathVariable("fees") int fees){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Doctor Experience Fees");
        List<Hospital> hospitalList= doctorService.getByDoctorExperienceFees(experience, fees);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/experiences/{experience}/totalConsults/{totalConsults}")
    public ResponseEntity<List<Hospital>> getByexperienceConsults(@PathVariable("experience") int experience,@PathVariable("totalConsults") int totalConsults){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Doctor Experience totalConsults");
        List<Hospital> hospitalList= doctorService.getByexperienceConsults(experience, totalConsults);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/doctorNames/{doctorName}/specializations/{specialization}/ratings/{rating}")
    public ResponseEntity<List<Hospital>> getByDoctorSpecRating(@PathVariable("doctorName") String doctorName,@PathVariable("specialization") String specialization,@PathVariable("rating") double rating){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Doctor Experience totalConsults");
        List<Hospital> hospitalList= doctorService.getByDoctorSpecRating(doctorName, specialization, rating);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }



}
