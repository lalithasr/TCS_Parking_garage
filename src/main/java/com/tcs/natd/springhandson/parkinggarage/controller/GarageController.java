package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.Garage;
import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.service.GarageService;
import com.tcs.natd.springhandson.parkinggarage.service.ParkingSpaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GarageController {
    private final GarageService garageService;
    private final ParkingSpaceService parkingSpaceService;


    public GarageController(GarageService garageService, ParkingSpaceService parkingSpaceService) {
        this.garageService = garageService;
        this.parkingSpaceService = parkingSpaceService;
    }

   // @GetMapping("/garages")
    @GetMapping("/garages")
    public List<Garage> getAllGarages() {
        return garageService.getAllGarages();
    }


    //@GetMapping("/garages/{id}")
    @GetMapping("/garages/{id}")
    public Garage getGarageById(@PathVariable Long id) {
        return garageService.getGarageById(id).orElse(null);
    }


    // This method returns all occupied parking spaces
    //@GetMapping("/garages/{id}/parkingspaces")
    @GetMapping("/garages/{id}/parkingspaces")
    public List<ParkingSpace> getAllOccupiedParkingSpaces(@PathVariable Long id) {
        return parkingSpaceService.findAllParkingSpacesByGarageId(id);
    }

    //@PostMapping("/garages")
    @PostMapping("/garages")
    public Garage addGarage(@RequestBody Garage garage) {
        return garageService.addGarage(garage);
    }

}
