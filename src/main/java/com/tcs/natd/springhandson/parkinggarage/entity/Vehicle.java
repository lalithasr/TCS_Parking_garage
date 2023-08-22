package com.tcs.natd.springhandson.parkinggarage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="make_id")
    Long makeId;

    @Column(name="license_plate")
    String licensePlate;

    String color;

    @Column(name = "user_id")
    Long userId;
}
