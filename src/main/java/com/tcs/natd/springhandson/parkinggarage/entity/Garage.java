package com.tcs.natd.springhandson.parkinggarage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "garages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String street;

    int floors;

/*    @OneToMany(mappedBy = "garage")
    @JsonIgnoreProperties("garage")
    private List<ParkingSpace> parkingSpaceList;*/
}
