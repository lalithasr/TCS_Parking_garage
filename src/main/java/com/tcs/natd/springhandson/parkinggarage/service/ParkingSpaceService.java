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
    public List<ParkingSpace> getAllParkingSpaces() {
        return parkingSpaceRepository.findAll();
    }


    //public ParkingSpace getParkingSpaceById(Long id) {
    public ParkingSpace getParkingSpaceById(Long id) {
        return parkingSpaceRepository.findById(id).orElse(null);
    }

    //public ParkingSpace getParkingSpaceByVehicleId(Long vehicleId) {
    public ParkingSpace getParkingSpaceByVehicleId(long l) {
        return parkingSpaceRepository.getParkingSpaceByVehicleId(l);
    }


    //public List<ParkingSpace> findAllParkingSpacesByGarageId(Long id) {
    public List<ParkingSpace> findAllParkingSpacesByGarageId(long l) {
        return parkingSpaceRepository.findAllParkingSpacesByGarageId(l);
    }



    //public ParkingSpace addParkingSpace(ParkingSpace parkingSpace) throws ParkingGarageException {
        // Check to make sure the parking space is valid.
        /*
            1. Check the floor to make sure its valid as compared to how many floors
            the garage has.
            2. Make sure that the parking space is not already taken
         */
    public ParkingSpace addParkingSpace(ParkingSpace parkingSpace) throws ParkingGarageException {
        Garage garage = garageRepository.findById(parkingSpace.getGarageId())
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        if (parkingSpace.getFloor() > garage.getFloors()) {
            throw new ParkingGarageException("Invalid floor number");
        }

        if (parkingSpace.getNumber() < 1 || parkingSpace.getNumber() > 100) {
            throw new ParkingGarageException("Invalid parking space number");
        }

        return parkingSpaceRepository.save(parkingSpace);
    }


    //public CarParkingDTO addParkingSpaceByCarParkingDTO(CarParkingDTO carParkingDTO) throws ParkingGarageException {
    public CarParkingDTO addParkingSpaceByCarParkingDTO(CarParkingDTO carParkingDTO) throws ParkingGarageException {
        Garage garage = garageRepository.findById(carParkingDTO.getGarageId())
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        if (carParkingDTO.getFloor() > garage.getFloors()) {
            throw new ParkingGarageException("Invalid floor number");
        }

        if (carParkingDTO.getNumber() < 1 || carParkingDTO.getNumber() > 100) {
            throw new ParkingGarageException("Invalid parking space number");
        }

        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setGarageId(garage.getId());
        parkingSpace.setFloor(carParkingDTO.getFloor());
        parkingSpace.setNumber(carParkingDTO.getNumber());
        parkingSpace.setVehicleId(carParkingDTO.getVehicleId());

        ParkingSpace savedParkingSpace = parkingSpaceRepository.save(parkingSpace);

        carParkingDTO.setId(savedParkingSpace.getId());
        return carParkingDTO;
    }

    //public void deleteParkingSpace(ParkingSpace parkingSpace) {
    public void deleteParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaceRepository.delete(parkingSpace);
    }

    public ParkingSpace addCarParkingDTO(CarParkingDTO carParkingDTO) {
        return null;
    }
}
