package com.hospitalapp.controllers;

import com.hospitalapp.model.Hospital;
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
@RequestMapping("hospital-response-api")
public class HospitalResponseController {

    private IHospitalService hospitalService;
    private Logger logger = LoggerFactory.getLogger(HospitalResponseController.class);
    @Autowired
    public void setHospitalService(IHospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }
    @PostMapping("/hospitals")
            public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital){
            logger.debug("inside Add Hospital method");
            HttpHeaders headers=new HttpHeaders();
            headers.add("desc","Adding new Hospital");
            Hospital nhospital=hospitalService.addHospital(hospital);
            logger.info("Hospital Added"+nhospital);
            return ResponseEntity.status(HttpStatus.CREATED).body(nhospital);
    }
    @PutMapping("/hospitals")
    public ResponseEntity<Void> updateHospital(@RequestBody Hospital hospital) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Updating a Hospital");
        hospitalService.updateHospital(hospital);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }
    @DeleteMapping("/hospitals/hospitalId/{hospitalId}")
    public ResponseEntity <String> deleteHospital(@PathVariable("hospitalId") int hospitalId) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","deleting a Hospital");
        hospitalService.deleteHospital(hospitalId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }
    @GetMapping("/hospitals/hospitalNames/{hospitalName}/locations/{location}")
    public ResponseEntity<List<Hospital>> getByHospitalLoc(@PathVariable("hospitalName") String hospitalName, @PathVariable("location") String location){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
       List<Hospital> hospitalList= hospitalService.getByHospitalLoc(hospitalName,location);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/hospitalNames/{hospitalName}/doctorNames/{doctorName}")
    public ResponseEntity<List<Hospital>>getByHospitalDoctor(@PathVariable("hospitalName") String hospitalName,@PathVariable("doctorName") String doctorName) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
        List<Hospital> hospitalList= hospitalService.getByHospitalDoctor(hospitalName, doctorName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/hospitalNames/{hospitalName}/patientNames/{patientName}")
    public ResponseEntity<List<Hospital>> getByHospitalPatient(@PathVariable("hospitalName") String hospitalName,@PathVariable("patientName") String patientName) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
        List<Hospital> hospitalList= hospitalService.getByHospitalPatient(hospitalName, patientName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/hospitalNames/{hospitalName}/patientNames/{patientName}/types/{type}")
    public ResponseEntity<List<Hospital>>getByHosPatType(@PathVariable("hospitalName") String hospitalName,@PathVariable("patientName") String patientName,@PathVariable("type") String type) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
        List<Hospital> hospitalList= hospitalService.getByHosPatType(hospitalName, patientName, type);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/patientNames/{patientName}")
    public ResponseEntity<List<Hospital>> getByPatient(@PathVariable("patientName") String patientName){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
        List<Hospital> hospitalList= hospitalService.getByPatient(patientName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }
    @GetMapping("/hospitals/types/{type}/patientNames/{patientName}")
    public ResponseEntity<List<Hospital>> getByTypePatient(@PathVariable("type") String type,@PathVariable("patientName") String patientName) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
        List<Hospital> hospitalList= hospitalService.getByTypePatient(type, patientName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);

    }
    @GetMapping("/hospitals/patientNames/{patientName}/age/{age}")
    public ResponseEntity<List<Hospital>> getByPatientAge(@PathVariable("patientName") String patientName,@PathVariable("age") int age) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
        List<Hospital> hospitalList= hospitalService.getByPatientAge(patientName, age);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);

    }
    @GetMapping("/hospitals/patientNames/{patientName}/gender/{gender}")
    public ResponseEntity<List<Hospital>> getByPatientGender(@PathVariable("patientName") String patientName,@PathVariable("gender") String gender){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
        List<Hospital> hospitalList= hospitalService.getByPatientGender(patientName,gender);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);

    }
    @GetMapping("/hospitals/patientNames/{patientName}/age/{age}/gender/{gender}")
    public ResponseEntity<List<Hospital>>getByNameAgeGender(@PathVariable("patientName") String patientName,@PathVariable("age") int age,@PathVariable("gender") String gender)  {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","hospitals details");
        List<Hospital> hospitalList= hospitalService.getByNameAgeGender(patientName,age,gender);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(hospitalList);
    }

}
