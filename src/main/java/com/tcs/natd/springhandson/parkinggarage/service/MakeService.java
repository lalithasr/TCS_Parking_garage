package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.Make;
import com.tcs.natd.springhandson.parkinggarage.repository.MakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakeService {

    private final MakeRepository makeRepository;

    public MakeService(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    public Make getMakeById(Long makeId) {
        return makeRepository.findById(makeId).orElse(null);
    }

    // public List<Make> findAllMakes() {
    public List<Make> findAllMakes() {
        return makeRepository.findAll();
    }

    //public Make getMakeById(Long id) {


    //public Make addMake(Make make) {
    public Make addMake(Make make) {
        return makeRepository.save(make);
    }

    //public void deleteMake(Make make) {
    public void deleteMake(Make make) {
        makeRepository.deleteById(make.getId());
    }


}
