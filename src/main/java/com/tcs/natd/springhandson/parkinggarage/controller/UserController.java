package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.entity.User;
import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import com.tcs.natd.springhandson.parkinggarage.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@GetMapping("/users")

    //@GetMapping("/users/{id}")


    //@GetMapping("users/{id}/vehicles")


    //@GetMapping("/users/{id}/parkingspaces")


    //@GetMapping("/users/email/{email}")



    //@GetMapping("/users/username/{username}")



    //@PostMapping("/users")


    //@DeleteMapping("/users")

}
