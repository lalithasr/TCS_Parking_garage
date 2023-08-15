package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.Make;
import com.tcs.natd.springhandson.parkinggarage.repository.MakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeService {

    private final MakeRepository makeRepository;

    public MakeService(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    public List<Make> findAllMakes() {
        return this.makeRepository.findAll();
    }

    public List<Make> getAllMakes() {
        return this.makeRepository.findAll();
    }

    public Make getMakeById(Long id) {
        return this.makeRepository.findById(id).orElseGet(Make::new);
    }

    public Make addMake(Make make) {
        return this.makeRepository.save(make);
    }

    public void deleteMake(Make make) {
        this.makeRepository.delete(make);
    }


}
