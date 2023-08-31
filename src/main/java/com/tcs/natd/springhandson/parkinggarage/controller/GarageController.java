package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.Garage;
import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.service.GarageService;
import com.tcs.natd.springhandson.parkinggarage.service.ParkingSpaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class GarageController {
    private final GarageService garageService;
    private final ParkingSpaceService parkingSpaceService;

    public GarageController(GarageService garageService, ParkingSpaceService parkingSpaceService) {
        this.garageService = garageService;
        this.parkingSpaceService = parkingSpaceService;
    }

   // @GetMapping("/garages")


    //@GetMapping("/garages/{id}")


    // This method returns all occupied parking spaces
    //@GetMapping("/garages/{id}/parkingspaces")

    //@PostMapping("/garages")

}
