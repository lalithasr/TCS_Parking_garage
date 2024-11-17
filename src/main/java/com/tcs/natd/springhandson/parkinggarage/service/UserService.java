package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.*;
import com.tcs.natd.springhandson.parkinggarage.repository.ParkingSpaceRepository;
import com.tcs.natd.springhandson.parkinggarage.repository.UserRepository;
import com.tcs.natd.springhandson.parkinggarage.repository.UserRoleRepository;
import com.tcs.natd.springhandson.parkinggarage.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository usersRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingSpaceRepository parkingSpaceRepository;
    private final UserRoleRepository userRoleRepository;

    public UserService(UserRepository usersRepository, VehicleRepository vehicleRepository, ParkingSpaceRepository parkingSpaceRepository, UserRoleRepository userRoleRepository) {
        this.usersRepository = usersRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.userRoleRepository = userRoleRepository;
    }


    //public List<User> getAllUsers() {
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    //public User getUserById(Long id) {
    public User getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    //public User getUserByUsername(String username) {
    public Optional<User> getUserByUsername(String username) {
        return usersRepository.getUserByUsername(username);
    }

    //public User getUserByEmail(String email) {
    public Optional<User> getUserByEmail(String mail) {
        return usersRepository.getUserByEmail(mail);
    }


    //public List<Vehicle> getVehiclesByUserId(Long userId) {
    public List<Vehicle> getVehiclesByUserId(long l) {
        return vehicleRepository.getVehiclesByUserId(l);
    }

    //public ParkingSpace getParkingSpaceByUserId(Long userId) {
    public ParkingSpace getParkingSpaceByUserId(long l) {
        return parkingSpaceRepository.getParkingSpaceById(l);
    }

    //public User addUser(User user) {
    public User addUser(User user) {
        User savedUser = usersRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(savedUser.getId());
        userRole.setRoleId(2L);
        userRoleRepository.save(userRole);
        return savedUser;
    }


    //public void deleteUser(User user) {
    public void deleteUser(User user) {
        usersRepository.delete(user);
    }

}
