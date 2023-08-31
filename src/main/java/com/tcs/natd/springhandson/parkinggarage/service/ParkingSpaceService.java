package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.Garage;
import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.exception.ParkingGarageException;
import com.tcs.natd.springhandson.parkinggarage.model.CarParkingDTO;
import com.tcs.natd.springhandson.parkinggarage.repository.GarageRepository;
import com.tcs.natd.springhandson.parkinggarage.repository.ParkingSpaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {
     private final ParkingSpaceRepository parkingSpaceRepository;
     private final GarageRepository garageRepository;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository, GarageRepository garageRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.garageRepository = garageRepository;
    }

    //public List<ParkingSpace> getAllParkingSpaces() {


    //public ParkingSpace getParkingSpaceById(Long id) {

    //public ParkingSpace getParkingSpaceByVehicleId(Long vehicleId) {


    //public List<ParkingSpace> findAllParkingSpacesByGarageId(Long id) {


    //public ParkingSpace addParkingSpace(ParkingSpace parkingSpace) throws ParkingGarageException {
        // Check to make sure the parking space is valid.
        /*
            1. Check the floor to make sure its valid as compared to how many floors
            the garage has.
            2. Make sure that the parking space is not already taken
         */


    //public CarParkingDTO addParkingSpaceByCarParkingDTO(CarParkingDTO carParkingDTO) throws ParkingGarageException {


    //public void deleteParkingSpace(ParkingSpace parkingSpace) {

}
