package com.tcs.natd.springhandson.parkinggarage.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
