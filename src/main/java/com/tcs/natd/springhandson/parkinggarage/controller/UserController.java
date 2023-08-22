package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.entity.User;
import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import com.tcs.natd.springhandson.parkinggarage.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("users/{id}/vehicles")
    public List<Vehicle> getVehiclesByUserId(@PathVariable Long id) {
        return this.userService.getVehiclesByUserId(id);
    }

    @GetMapping("/users/{id}/parkingspaces")
    public ParkingSpace getParkingSpacesByUserId(@PathVariable Long id) {
        return this.userService.getParkingSpaceByUserId(id);
    }

    @GetMapping("/users/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return this.userService.getUserByEmail(email);
    }


    @GetMapping("/users/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return this.userService.getUserByUsername(username);
    }


    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }


    @DeleteMapping("/users")
    public void deleteUser(@RequestBody User user) {
        this.userService.deleteUser(user);
    }
}
