package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.repository.ParkingSpaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {
     private final ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    public List<ParkingSpace> getAllParkingSpaces() {
        return this.parkingSpaceRepository.findAll();
    }

    public ParkingSpace getParkingSpaceById(Long id) {
        return this.parkingSpaceRepository.findById(id).orElseGet(ParkingSpace::new);
    }

    public ParkingSpace addParkingSpace(ParkingSpace parkingSpace) {
        return this.parkingSpaceRepository.save(parkingSpace);
    }

    public void deleteParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpaceRepository.delete(parkingSpace);
    }
}
