package com.tcs.natd.springhandson.parkinggarage.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarParkingDTO {
    Long id;
    Long garageId;
    int floor;
    int number;
    Long vehicleId;
}
