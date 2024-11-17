package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.Make;
import com.tcs.natd.springhandson.parkinggarage.service.MakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MakeController {

    private final MakeService makeService;

    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    //@GetMapping("/makes")
    @GetMapping("/makes")
    public List<Make> getAllMakes() {
        return makeService.findAllMakes();
    }


    //@GetMapping("/makes/{id}")
    @GetMapping("/makes/{id}")
    public Make getMakeById(@PathVariable Long id) {
        return makeService.getMakeById(id);
    }


    //@PostMapping("/makes")
    @PostMapping("/makes")
    public Make addMake(@RequestBody Make make) {
        return makeService.addMake(make);
    }


    //@DeleteMapping("makes/{id}")
    @DeleteMapping("makes/{id}")
    public void deleteMake(@PathVariable Long id) {
        Make make = makeService.getMakeById(id);
        makeService.deleteMake(make);
    }


}
