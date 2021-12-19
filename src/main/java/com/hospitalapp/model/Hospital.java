package com.hospitalapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="Hospital")
public class Hospital {
    @Id
    @GeneratedValue(generator = "hospital_seq",strategy  =GenerationType.AUTO)
    @SequenceGenerator(name = "hospital_seq",sequenceName = "hospital_sequence",initialValue = 1,allocationSize = 1)
    private int hospitalId;
    @Column(length=20)
    private String hospitalName;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="haddress_id")         //(one address-one Hospital)
    private HAddress hAddress;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "hospital_doctor",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))       //(one doctor can work in many hospitals so it is many to many)
    private Set<Doctor> doctors;
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)//this is the foreign key that will be added to table
    @JoinColumn(name="hospital_id")
    private Set<Patient> patients;


    public Hospital(String hospitalName, HAddress hAddress, Set<Doctor> doctors, Set<Patient> patients) {
        this.hospitalName = hospitalName;
        this.hAddress = hAddress;
        this.doctors = doctors;
        this.patients = patients;
    }
}


