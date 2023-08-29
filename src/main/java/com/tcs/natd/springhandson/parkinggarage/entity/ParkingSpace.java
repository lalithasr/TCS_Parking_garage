package com.tcs.natd.springhandson.parkinggarage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "parking_spaces")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

/*    @Column(name="garage_id")
    Long garageId;*/
   // @JsonIgnoreProperties("")
    @ManyToOne
    @JoinColumn(name = "garage_id")
    //@JsonIgnoreProperties("garage")
    Garage garage;

    int floor;

    int number;

    @Column(name="vehicle_id")
    Long vehicleId;
}
