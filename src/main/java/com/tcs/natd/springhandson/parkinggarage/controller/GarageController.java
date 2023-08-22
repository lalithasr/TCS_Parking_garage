package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.Garage;
import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.service.GarageService;
import com.tcs.natd.springhandson.parkinggarage.service.ParkingSpaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GarageController {
    private final GarageService garageService;
    private final ParkingSpaceService parkingSpaceService;

    public GarageController(GarageService garageService, ParkingSpaceService parkingSpaceService) {
        this.garageService = garageService;
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping("/garages")
    public List<Garage> findAllGarages() {
        return this.garageService.getAllGarages();
    }

    @GetMapping("/garages/{id}")
    public Garage getGarageById(@PathVariable Long id) {
        return this.garageService.getGarageById(id);
    }

    // This method returns all occupied parking spaces
    @GetMapping("/garages/{id}/parkingspaces")
    public List<ParkingSpace> getParkingSpaceByGarageId(@PathVariable Long id) {
        return this.parkingSpaceService.findAllParkingSpacesByGarageId(id);
    }

    @PostMapping("/garages")
    public Garage addGarage(@RequestBody Garage garage) {
        return this.garageService.addGarage(garage);
    }

}
