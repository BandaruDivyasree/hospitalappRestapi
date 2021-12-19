package com.hospitalapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Data
@Entity
public class HAddress {
    @Id
    @Column(name="haddressId")
    @GeneratedValue(generator = "haddress_seq",strategy  = GenerationType.AUTO)
    @SequenceGenerator(name = "haddress_seq",sequenceName = "haddress_sequence",initialValue = 1,allocationSize = 1)
    private Integer hAddressId;
    @Column(name = "streetname",length = 20)
    private String streetName;
    @Column(length = 20)
    private String location;
    @Column(name = "city",length = 20)
    private String city;
    @Column(name="state",length=20)
    private String state;
    @Column(length = 20)
    private int zipcode;

    public HAddress(String streetName, String location, String city, String state, int zipcode) {
        this.streetName = streetName;
        this.location = location;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
