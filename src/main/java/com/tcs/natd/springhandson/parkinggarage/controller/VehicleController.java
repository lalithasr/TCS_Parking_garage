package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import com.tcs.natd.springhandson.parkinggarage.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //@GetMapping("/vehicles")

    //@GetMapping("/vehicles/{id}")

    //@GetMapping("/vehicles/{make}")

    //@PostMapping("/vehicles")

    //@DeleteMapping("/vehicles")

}
