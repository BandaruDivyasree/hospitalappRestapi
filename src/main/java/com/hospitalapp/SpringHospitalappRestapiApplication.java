package com.hospitalapp;

import com.hospitalapp.model.*;
import com.hospitalapp.service.IDoctorService;
import com.hospitalapp.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringHospitalappRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringHospitalappRestapiApplication.class, args);
	}
	@Autowired
	private IHospitalService hospitalService;

	@Autowired
	private IDoctorService doctorService;

	@Override
	public void run(String... args) throws Exception {
//		//one to one
//		HAddress hAddress = new HAddress("KK Nagar", "Himayat Board", "Guntur", "Andhra pradesh", 515004);
//
//		//one to many
//		Patient patient1 = new Patient("Niranjan", 18, "Male", "Ameerpet", Type.IN);
//		Patient patient2 = new Patient("Thanmayi", 22, "Female", "silicon valley", Type.OUT);
//		Patient patient3 = new Patient("Mallika", 21, "Female", "Aravind Nagar", Type.IN);
//		Patient patient4 = new Patient("Rajsekhar", 22, "Male", "Hi-tech", Type.OUT);
//		Set<Patient> patients = new HashSet<>(Arrays.asList(patient1, patient2, patient3, patient4));
//
//
//		//many to many
//
//		Doctor doctor1 = doctorService.getById(2);
//		Doctor doctor2=doctorService.getById(3);
//		//Doctor doctor1 = new Doctor("Kelly", "Surgeon", 9, 5000, 90, 4.2);
//		//Doctor doctor2 = new Doctor("Divya", "Dermatology", 11, 10000, 108, 4.8);
//		Doctor doctor3 = doctorService.getById(10);
//		Doctor doctor4=doctorService.getById(11);
//		//Doctor doctor3 = new Doctor("Priya", "Physician", 30, 8500, 105, 3.5);
//		//Doctor doctor4 = new Doctor("Kathy", "Neurologist", 45, 15000, 20000, 5.0);
////		doctorService.addDoctor(doctor3);
////		doctorService.addDoctor(doctor4);
//
//
//
//		Set<Doctor> doctors = new HashSet<>(Arrays.asList(doctor3, doctor4));
//
//		Hospital hospital5=hospitalService.getById(5);
//		System.out.println(hospital5);
//		hospital5.setDoctors(doctors);
//
//
//		//List<Hospital> hospital1 = hospitalService.getByHospitalName("Rainbow");
////		Hospital hospital = new Hospital(hospital5.getHospitalName(), hAddress, doctors, patients);
////		Hospital hospital2=new Hospital("Pace",hAddress,doctors,patients);
////		Hospital hospital3=new Hospital("Vikram",hAddress,doctors,patients);
////		Hospital hospital4=new Hospital("Savera",hAddress,doctors,patients);
//		//Set<Hospital> hospital=new HashSet<>(Arrays.asList(hospital1,hospital2,hospital3,hospital4));
//
//		//hospitalService.updateHospital(hospital5);
//		Hospital hospital=new Hospital("Rainbow",hAddress,doctors,patients);
//		hospitalService.addHospital(hospital);


	}
}
