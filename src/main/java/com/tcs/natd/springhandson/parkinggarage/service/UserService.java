package com.tcs.natd.springhandson.parkinggarage.service;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import com.tcs.natd.springhandson.parkinggarage.entity.User;
import com.tcs.natd.springhandson.parkinggarage.entity.UserRole;
import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import com.tcs.natd.springhandson.parkinggarage.repository.ParkingSpaceRepository;
import com.tcs.natd.springhandson.parkinggarage.repository.UserRepository;
import com.tcs.natd.springhandson.parkinggarage.repository.UserRoleRepository;
import com.tcs.natd.springhandson.parkinggarage.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //public User getUserById(Long id) {

    //public User getUserByUsername(String username) {

    //public User getUserByEmail(String email) {


    //public List<Vehicle> getVehiclesByUserId(Long userId) {

    //public ParkingSpace getParkingSpaceByUserId(Long userId) {

    //public User addUser(User user) {


    //public void deleteUser(User user) {

}
