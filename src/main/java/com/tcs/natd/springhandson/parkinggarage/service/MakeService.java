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

   // public List<Make> findAllMakes() {

    //public Make getMakeById(Long id) {

    //public Make addMake(Make make) {

    //public void deleteMake(Make make) {


}
