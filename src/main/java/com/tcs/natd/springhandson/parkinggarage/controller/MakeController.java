package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.Make;
import com.tcs.natd.springhandson.parkinggarage.service.MakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MakeController {

    private final MakeService makeService;

    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    @GetMapping("/makes")
    public List<Make> getAllMakes() {
        return this.makeService.findAllMakes();
    }

    @GetMapping("/makes/{id}")
    public Make getMakeById(@PathVariable Long id) {
        return this.makeService.getMakeById(id);
    }

    @PostMapping("/makes")
    public Make addMake(@RequestBody Make make){
        return this.makeService.addMake(make);
    }

    @DeleteMapping("makes/{id}")
    public void deleteMake(@PathVariable Long id) {
        Make myMake = new Make();
        myMake.setId(id);
        this.makeService.deleteMake(myMake);
    }
}
