package com.tcs.natd.springhandson.parkinggarage.controller;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.entity.User;
import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import com.tcs.natd.springhandson.parkinggarage.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@GetMapping("/users")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    //@GetMapping("/users/{id}")
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    //@GetMapping("users/{id}/vehicles")
    @GetMapping("users/{id}/vehicles")
    public List<Vehicle> getVehiclesByUserId(@PathVariable Long id) {
        return userService.getVehiclesByUserId(id);
    }


    //@GetMapping("/users/{id}/parkingspaces")
    @GetMapping("/users/{id}/parkingspaces")
    public ParkingSpace getParkingSpaceByUserId(@PathVariable Long id) {
        return userService.getParkingSpaceByUserId(id);
    }


    //@GetMapping("/users/email/{email}")
    @GetMapping("/users/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }



    //@GetMapping("/users/username/{username}")
    @GetMapping("/users/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }



    //@PostMapping("/users")
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


    //@DeleteMapping("/users")
    @DeleteMapping("/users")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

}
