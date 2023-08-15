package com.tcs.natd.springhandson.parkinggarage.entity;

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

    @Column(name="garage_id")
    Long garageId;

    int floor;

    @Column(name="vehicle_id")
    Long vehicleId;
}
