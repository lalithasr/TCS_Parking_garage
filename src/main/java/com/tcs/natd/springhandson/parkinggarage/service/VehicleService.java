package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.Make;
import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import com.tcs.natd.springhandson.parkinggarage.repository.MakeRepository;
import com.tcs.natd.springhandson.parkinggarage.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }




    // public List<Vehicle> getAllVehicles() {
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    //public Vehicle getVehicleById(Long id) {
    public Vehicle getVehicleById(Long vehicleid) {
        return vehicleRepository.findById(vehicleid).orElse(null);
    }


    //public List<Vehicle> getVehiclesByMakeName(String makeName) {
    public List<Vehicle> getVehiclesByMakeName(String makeName) {
        return vehicleRepository.findAllByMakeName(makeName);
    }


    //public Vehicle addVehicle(Vehicle vehicle) {
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }


    //public void deleteVehicle(Vehicle vehicle) {
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.deleteById(vehicle.getId());
    }

}
