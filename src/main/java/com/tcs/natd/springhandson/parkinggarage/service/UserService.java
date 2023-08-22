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

    public List<User> getAllUsers() {
        return this.usersRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.usersRepository.findById(id).orElseGet(User::new);
    }

    public User getUserByUsername(String username) {
        return this.usersRepository.getUserByUsername(username);
    }

    public User getUserByEmail(String email) {
        return this.usersRepository.getUserByEmail(email);
    }

    public List<Vehicle> getVehiclesByUserId(Long userId) {
        return this.vehicleRepository.findAllByUserId(userId);
    }

    public ParkingSpace getParkingSpaceByUserId(Long userId) {
        return this.parkingSpaceRepository.findParkingSpaceByUserId(userId);
    }

    public User addUser(User user) {
        User newUser = this.usersRepository.save(user);

        UserRole userRole = new UserRole();

        // All users will at least have the role of customer (id 2)
        userRole.setRoleId(2L);
        userRole.setUserId(newUser.getId());
        this.userRoleRepository.save(userRole);

        return newUser;
    }

    public void deleteUser(User user) {
        this.usersRepository.delete(user);
    }
}
