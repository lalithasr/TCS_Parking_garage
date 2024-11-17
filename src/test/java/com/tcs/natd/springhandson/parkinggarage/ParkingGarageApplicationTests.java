package com.tcs.natd.springhandson.parkinggarage;

import com.tcs.natd.springhandson.parkinggarage.entity.*;
import com.tcs.natd.springhandson.parkinggarage.exception.ParkingGarageException;
import com.tcs.natd.springhandson.parkinggarage.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ParkingGarageApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private ParkingSpaceService parkingSpaceService;
	@Autowired
	private UserService userService;
	@Autowired
	private MakeService makeService;

	@Autowired
	private GarageService garageService;

	@Test
	void getGarageControllerLayerTest() throws Exception {
		Optional<Garage> garage = this.garageService.getGarageById(2L);
		assertEquals("481 main street", garage.get().getStreet());
	}

	@Test
	void getMakeByIdControllerLayerTest() throws Exception {
		Optional<Make> make = Optional.ofNullable(this.makeService.getMakeById(2L));
		assertEquals("honda", make.get().getName());
	}

	@Test
	void addParkingSpaceServiceLayerTest() throws Exception {
		ParkingSpace newParkingSpace = new ParkingSpace();
		Garage newGarage = new Garage();
		newGarage.setId(1L);
		newParkingSpace.setGarageId(newGarage.getId());
		newParkingSpace.setFloor(4);
		newParkingSpace.setNumber(30);

		Vehicle myVehicle = new Vehicle();
		myVehicle.setColor("blue");
		myVehicle.setLicensePlate("OBG 1234");
		myVehicle.setMakeId(1L);
		myVehicle.setUserId(2L);

		Vehicle vehicle = this.vehicleService.addVehicle(myVehicle);

		newParkingSpace.setVehicleId(vehicle.getId());

		ParkingSpace tempParkingSpace = this.parkingSpaceService.addParkingSpace(newParkingSpace);

		ParkingSpace addedParkingSpace = this.parkingSpaceService.getParkingSpaceById(tempParkingSpace.getId());

		assertEquals(addedParkingSpace.getVehicleId(), vehicle.getId());

		this.parkingSpaceService.deleteParkingSpace(addedParkingSpace);
		this.vehicleService.deleteVehicle(vehicle);


	}

	@Test
	void addInvalidParkingSpaceServiceLayerTest() throws Exception {
		ParkingSpace newParkingSpace = new ParkingSpace();
		Garage newGarage = new Garage();
		newGarage.setId(1L);
		newParkingSpace.setGarageId(newGarage.getId());
		newParkingSpace.setFloor(4);
		newParkingSpace.setNumber(101);

		Vehicle myVehicle = new Vehicle();
		myVehicle.setColor("blue");
		myVehicle.setLicensePlate("OBG 1234");
		myVehicle.setMakeId(1L);
		myVehicle.setUserId(2L);

		Vehicle addedVehicle = this.vehicleService.addVehicle(myVehicle);

		newParkingSpace.setVehicleId(addedVehicle.getId());

		assertThrows(ParkingGarageException.class, () -> {this.parkingSpaceService.addParkingSpace(newParkingSpace); });

		this.vehicleService.deleteVehicle(addedVehicle);

	}

	@Test
	void getVehiclesByUserIdTest() {
		List<Vehicle> vehicles = this.userService.getVehiclesByUserId(2L);
		Make myMake = this.makeService.getMakeById(vehicles.get(0).getMakeId());
		assertEquals("ferrari", myMake.getName());
	}


	@Test
	void getParkingSpaceByVehicleIdTest() {
		ParkingSpace parkingSpace = this.parkingSpaceService.getParkingSpaceByVehicleId(1L);
		Vehicle myVehicle = this.vehicleService.getVehicleById(parkingSpace.getVehicleId());

		assertEquals("IAMRICH", myVehicle.getLicensePlate());
	}

	@Test
	void findAllParkingSpacesByGarageIdTest() {
		List<ParkingSpace> parkingSpaceList = this.parkingSpaceService.findAllParkingSpacesByGarageId(2L);
		assertEquals(1, parkingSpaceList.size());
	}

	@Test
	void getUsernameByEmailTest() {
		Optional<User> user = this.userService.getUserByEmail("jane.parker@example.com");
		assertEquals("Jane", user.get().getFirstName());
	}
}
