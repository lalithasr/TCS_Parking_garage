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

    public List<ParkingSpace> getAllParkingSpaces() {
        return this.parkingSpaceRepository.findAll();
    }

    public ParkingSpace getParkingSpaceById(Long id) {
        return this.parkingSpaceRepository.findById(id).orElseGet(ParkingSpace::new);
    }

    public ParkingSpace getParkingSpaceByVehicleId(Long vehicleId) {
        return this.parkingSpaceRepository.findByVehicleId(vehicleId);
    }

    public List<ParkingSpace> findAllParkingSpacesByGarageId(Long id) {
        return this.parkingSpaceRepository.findAllByGarageId(id);
    }

    public ParkingSpace addParkingSpace(ParkingSpace parkingSpace) throws ParkingGarageException {
        // Check to make sure the parking space is valid.
        /*
            1. Check the floor to make sure its valid as compared to how many floors
            the garage has.
            2. Make sure that the parking space is not already taken
         */
        Garage myGarage = this.garageRepository.findById(parkingSpace.getGarage().getId())
                .orElseGet(Garage::new);

        // if the ID is null or 0 then we failed to find a garage.
        if(myGarage.getId() == null || myGarage.getId() == 0L) {
            throw new ParkingGarageException("Could not add parking space to invalid Garage.");
        }

        if(parkingSpace.getFloor() > myGarage.getFloors())
            throw new ParkingGarageException("Invalid floor for Garage "+myGarage.getStreet()+
                    ". Max floor is "+myGarage.getFloors());

        // Check for a valid parking space number
        if(parkingSpace.getNumber() > 100) {
            throw new ParkingGarageException("Invalid parking space number: " + parkingSpace.getNumber()+ ". This parking garage floor: "+myGarage.getStreet()+" - floor "+parkingSpace.getFloor()+", has only 100 spaces");
        }

        ParkingSpace existingParkingSpace = this.parkingSpaceRepository.findParkingSpaceByFloorAndGarageIdAndNumber(parkingSpace.getFloor(), parkingSpace.getGarage().getId(), parkingSpace.getNumber());
        if(null != existingParkingSpace) {
            throw new ParkingGarageException("Parking Space "+parkingSpace.getNumber()+" is already taken.");
        }

        return this.parkingSpaceRepository.save(parkingSpace);
    }

    public CarParkingDTO addParkingSpaceByCarParkingDTO(CarParkingDTO carParkingDTO) throws ParkingGarageException {
        ParkingSpace newParkingSpace = new ParkingSpace();
        Garage newGarage = new Garage();
        newGarage.setId(carParkingDTO.getGarageId());
        newParkingSpace.setGarage(newGarage);
        newParkingSpace.setFloor(carParkingDTO.getFloor());
        newParkingSpace.setVehicleId(carParkingDTO.getVehicleId());
        newParkingSpace.setNumber(carParkingDTO.getNumber());
        ParkingSpace addedParkingSpace = this.parkingSpaceRepository.save(newParkingSpace);
        carParkingDTO.setId(addedParkingSpace.getId());
        return carParkingDTO;
    }

    public void deleteParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpaceRepository.delete(parkingSpace);
    }
}
