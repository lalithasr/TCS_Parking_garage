package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import com.tcs.natd.springhandson.parkinggarage.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return this.vehicleRepository.findById(id).orElseGet(Vehicle::new);
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Vehicle vehicle) {
        this.vehicleRepository.delete(vehicle);
    }
}
