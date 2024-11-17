package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.exception.ParkingGarageException;
import com.tcs.natd.springhandson.parkinggarage.model.CarParkingDTO;
import com.tcs.natd.springhandson.parkinggarage.service.ParkingSpaceService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/api")
public class ParkingSpaceController {
    //Logger logger = LogManager.getLogger(ParkingSpaceController.class);
    private final ParkingSpaceService parkingSpaceService;

    public ParkingSpaceController(ParkingSpaceService parkingSpaceService) {
        this.parkingSpaceService = parkingSpaceService;
    }

    //@GetMapping("/parkingspaces")
    @GetMapping("/parkingspaces")
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceService.getAllParkingSpaces();
    }


    //@GetMapping("/parkingspaces/{id}")
    @GetMapping("/parkingspaces/{id}")
    public ParkingSpace getParkingSpaceById(@PathVariable Long id) {
        return parkingSpaceService.getParkingSpaceById(id);
    }

    //@GetMapping("/parkingspaces/vehicles/{id}")
    @GetMapping("/parkingspaces/vehicles/{id}")
    public ParkingSpace getParkingSpaceByVehicleId(@PathVariable Long id) {
        return parkingSpaceService.getParkingSpaceByVehicleId(id);
    }


    //@PostMapping("/parkingspaces")
    @PostMapping("/parkingspaces")
    public ResponseEntity<Object> addParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        try {
            return new ResponseEntity<>(parkingSpaceService.addParkingSpace(parkingSpace), HttpStatus.CREATED);
        } catch (ParkingGarageException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //@PostMapping("/carParkingDTO")
    @PostMapping("/carParkingDTO")
    public ParkingSpace addCarParkingDTO(@RequestBody CarParkingDTO carParkingDTO) {
        return parkingSpaceService.addCarParkingDTO(carParkingDTO);
    }



    // Used when a customer leaves the garage and pays for their stay.
    //@DeleteMapping("/parkingspaces/{id}")
    @DeleteMapping("/parkingspaces/{id}")
    public void deleteParkingSpace(@PathVariable Long id) {
        ParkingSpace parkingSpace = parkingSpaceService.getParkingSpaceById(id);
        parkingSpaceService.deleteParkingSpace(parkingSpace);
    }

}
