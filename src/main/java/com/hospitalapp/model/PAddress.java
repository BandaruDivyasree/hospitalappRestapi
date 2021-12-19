package com.hospitalapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Data
@Entity
public class PAddress {
    @Id
    @Column(name="paddressId")
    @GeneratedValue(generator = "paddress_seq",strategy  = GenerationType.AUTO)
    @SequenceGenerator(name = "paddress_seq",sequenceName = "paddress_sequence",initialValue = 1,allocationSize = 1)
    private int pAddressId;
    @Column(length=20)
    private String  doorNo;
    @Column(length =20,name="streetname")
    private String streetName;
    @Column(length = 20,name="buildingname")
    private String  buildingName;
    @Column(length = 20,name="location")
    private String location;
    @Column(length = 20,name="city")
    private String city;
    @Column(length = 20,name="state")
    private String state;
    @Column(length = 20)
    private int  zipcode;

    public PAddress(String doorNo, String streetName, String buildingName, String location, String city, String state, int zipcode) {
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.buildingName = buildingName;
        this.location = location;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
