package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.Garage;
import com.tcs.natd.springhandson.parkinggarage.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageService {
    private final GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    //public List<Garage> getAllGarages()
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    //public Garage getGarageById(Long id) {
    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id);
    }

    //public Garage addGarage(Garage garage) {
    public Garage addGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    //public void deleteGarage(Garage garage) {
    public void deleteGarage(Garage garage) {
        garageRepository.deleteById(garage.getId());
    }

}
