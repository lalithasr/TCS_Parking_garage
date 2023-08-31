package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.Make;
import com.tcs.natd.springhandson.parkinggarage.service.MakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class MakeController {

    private final MakeService makeService;

    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    //@GetMapping("/makes")


    //@GetMapping("/makes/{id}")


    //@PostMapping("/makes")


    //@DeleteMapping("makes/{id}")


}
