package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.exception.ParkingGarageException;
import com.tcs.natd.springhandson.parkinggarage.service.ParkingSpaceService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import lombok.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
public class ParkingSpaceController {
    //Logger logger = LogManager.getLogger(ParkingSpaceController.class);
    private final ParkingSpaceService parkingSpaceService;

    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    @GetMapping("/parkingspaces")
    public List<ParkingSpace> getAllParkingSpaces() {
        return this.parkingSpaceService.getAllParkingSpaces();
    }

    @GetMapping("/parkingspaces/{id}")
    public ParkingSpace getParkingSpaceById(@PathVariable Long id) {
        return this.parkingSpaceService.getParkingSpaceById(id);
    }

    @PostMapping("/parkingspaces")
    public ParkingSpace addParkingSpace(@RequestBody ParkingSpace parkingSpace,  HttpServletResponse response) {
        try {
            return this.parkingSpaceService.addParkingSpace(parkingSpace);
        } catch (ParkingGarageException pge) {
            log.error(pge.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, pge.getMessage(), pge);

        }
    }


    // Used when a customer leaves the garage and pays for their stay.
    @DeleteMapping("/parkingspaces/{id}")
    public void deleteParkingSpace(@PathVariable Long id) {
        ParkingSpace pSpace = new ParkingSpace();
        pSpace.setId(id);
        this.parkingSpaceService.deleteParkingSpace(pSpace);
    }
}
