package com.hospitalapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(generator = "patient_seq",strategy  = GenerationType.AUTO)
    @SequenceGenerator(name = "patient_seq",sequenceName = "patient_sequence",initialValue = 1,allocationSize = 1)
    private int patientId;
    @Column(name = "patientname",length = 20)
    private String patientName;
    @Column(length = 20)
    private int age;
    @Column(name = "gender",length = 20)
    private String gender;
    @Column(length = 20)
    private String pAddress;
    @Enumerated(EnumType.STRING)
    private Type type; //in/out

    public Patient(String patientName, int age, String gender, String pAddress, Type type) {
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.pAddress = pAddress;
        this.type = type;
    }
}
