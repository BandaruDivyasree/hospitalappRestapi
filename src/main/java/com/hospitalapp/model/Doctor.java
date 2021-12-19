package com.hospitalapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(generator = "doctor_seq",strategy  = GenerationType.AUTO)
    @SequenceGenerator(name = "doctor_seq",sequenceName = "doctor_sequence",initialValue = 1,allocationSize = 1)
    private int doctorId;
    @Column(name="doctorname",length=20)
    private String doctorName;
    @Column(name="specalization",length=20)
    private String specialization;
    @Column(length = 20)
    private int experience;
    @Column(length = 20)
    private int fees;
    @Column(length = 20)
    private int totalConsults;
    @Column(length = 20)
    private double rating;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy="doctors")//(In many hospitals the doctor can there)
    @JsonIgnore
    private Set<Hospital> Hospital;

    public Doctor(String doctorName, String specialization, int experience, int fees, int totalConsults, double rating) {
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.experience = experience;
        this.fees = fees;
        this.totalConsults = totalConsults;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorName='" + doctorName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experience +
                ", fees=" + fees +
                ", totalConsults=" + totalConsults +
                ", rating=" + rating +
                '}';
    }
}

