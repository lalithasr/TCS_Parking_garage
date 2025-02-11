package com.tcs.natd.springhandson.parkinggarage.repository;

import com.tcs.natd.springhandson.parkinggarage.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findByVehicleId(Long id);

    List<ParkingSpace> findAllByGarageId(Long garageId);

    @Query(value = "SELECT parking_spaces.id, parking_spaces.garage_id, parking_spaces.floor, " +
            "parking_spaces.number, parking_spaces.vehicle_id FROM parking_Spaces JOIN vehicles " +
            "ON vehicles.id = parking_spaces.vehicle_id JOIN users ON users.id = vehicles.user_id " +
            "WHERE USER_ID = ?", nativeQuery = true)
    ParkingSpace findParkingSpaceById(Long userId);

    ParkingSpace findParkingSpaceByFloorAndGarageIdAndNumber(int floor, Long garageId, int number);

    ParkingSpace getParkingSpaceById(long l);

    ParkingSpace getParkingSpaceByVehicleId(long l);

    List<ParkingSpace> findAllParkingSpacesByGarageId(long l);


}
