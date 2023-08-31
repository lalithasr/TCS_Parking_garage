package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.exception.ParkingGarageException;
import com.tcs.natd.springhandson.parkinggarage.model.CarParkingDTO;
import com.tcs.natd.springhandson.parkinggarage.service.ParkingSpaceService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.server.ResponseStatusException;


public class ParkingSpaceController {
    //Logger logger = LogManager.getLogger(ParkingSpaceController.class);
    private final ParkingSpaceService parkingSpaceService;

    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    //@GetMapping("/parkingspaces")


    //@GetMapping("/parkingspaces/{id}")


    //@GetMapping("/parkingspaces/vehicles/{id}")


    //@PostMapping("/parkingspaces")


    //@PostMapping("/carParkingDTO")



    // Used when a customer leaves the garage and pays for their stay.
    //@DeleteMapping("/parkingspaces/{id}")

}
