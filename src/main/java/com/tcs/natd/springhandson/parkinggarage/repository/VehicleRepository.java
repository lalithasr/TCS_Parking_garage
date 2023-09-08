package com.tcs.natd.springhandson.parkinggarage.repository;


import com.tcs.natd.springhandson.parkinggarage.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface VehicleRepository  {
    List<Vehicle> findAllByColor(String color);
    Vehicle findByLicensePlate(String licensePlate);
    List<Vehicle> findAllByUserId(Long userId);

    @Query(value="SELECT vehicles.id, vehicles.make_id, vehicles.license_plate, vehicles.user_id, vehicle.color FROM "
            + "vehicles JOIN makes on vehicles.make_id = makes.id where makes.name = ?", nativeQuery = true)
    List<Vehicle> findAllByMakeName(String make);
}
