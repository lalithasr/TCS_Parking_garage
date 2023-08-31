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

   // public List<Vehicle> getAllVehicles() {

    //public Vehicle getVehicleById(Long id) {


    //public List<Vehicle> getVehiclesByMakeName(String makeName) {


    //public Vehicle addVehicle(Vehicle vehicle) {


    //public void deleteVehicle(Vehicle vehicle) {

}
