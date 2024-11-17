package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import com.tcs.natd.springhandson.parkinggarage.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //@GetMapping("/vehicles")
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }


    //@GetMapping("/vehicles/{id}")
    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    //@GetMapping("/vehicles/{make}")
    @GetMapping("/vehicles/{make}")
    public List<Vehicle> getVehiclesByMakeName(@PathVariable String make) {
        return vehicleService.getVehiclesByMakeName(make);
    }

    //@PostMapping("/vehicles")
    @PostMapping("/vehicles")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    //@DeleteMapping("/vehicles")
    @DeleteMapping("/vehicles")
    public void deleteVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.deleteVehicle(vehicle);
    }

}
