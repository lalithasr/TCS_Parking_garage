package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.Garage;
import com.tcs.natd.springhandson.parkinggarage.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {
    private final GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public List<Garage> getAllGarages() {
        return this.garageRepository.findAll();
    }

    public Garage getGarageById(Long id) {
        return this.garageRepository.findById(id).orElseGet(Garage::new);
    }

    public Garage addGarage(Garage garage) {
        return this.garageRepository.save(garage);
    }

    public void deleteGarage(Garage garage) {
        this.garageRepository.delete(garage);
    }
}
