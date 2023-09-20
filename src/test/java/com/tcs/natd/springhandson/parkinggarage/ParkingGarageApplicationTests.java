package com.tcs.natd.springhandson.parkinggarage;

import com.tcs.natd.springhandson.parkinggarage.entity.*;
import com.tcs.natd.springhandson.parkinggarage.exception.ParkingGarageException;
import com.tcs.natd.springhandson.parkinggarage.service.MakeService;
import com.tcs.natd.springhandson.parkinggarage.service.ParkingSpaceService;
import com.tcs.natd.springhandson.parkinggarage.service.UserService;
import com.tcs.natd.springhandson.parkinggarage.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

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

	@Test
	void getGarageControllerLayerTest() throws Exception {
		this.mockMvc.perform(get("/garages/2"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("481 main street")));
	}

	@Test
	void getMakeByIdControllerLayerTest() throws Exception {
		this.mockMvc.perform(get("/makes/2"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("honda")));
	}

	@Test
	void addParkingSpaceServiceLayerTest() throws Exception {
		ParkingSpace newParkingSpace = new ParkingSpace();
		Garage newGarage = new Garage();
		newGarage.setId(1L);
		newParkingSpace.setGarage(newGarage);
		newParkingSpace.setFloor(4);
		newParkingSpace.setNumber(30);

		Vehicle myVehicle = new Vehicle();
		myVehicle.setColor("blue");
		myVehicle.setLicensePlate("OBG 1234");
		myVehicle.setMakeId(1L);
		myVehicle.setUserId(2L);

		Vehicle addedVehicle = this.vehicleService.addVehicle(myVehicle);

		newParkingSpace.setVehicleId(addedVehicle.getId());

		ParkingSpace tempParkingSpace = this.parkingSpaceService.addParkingSpace(newParkingSpace);

		ParkingSpace addedParkingSpace = this.parkingSpaceService.getParkingSpaceById(tempParkingSpace.getId());

		assertEquals(addedParkingSpace.getVehicleId(), addedVehicle.getId());

		this.parkingSpaceService.deleteParkingSpace(addedParkingSpace);
		this.vehicleService.deleteVehicle(addedVehicle);


	}

	@Test
	void addInvalidParkingSpaceServiceLayerTest() throws Exception {
		ParkingSpace newParkingSpace = new ParkingSpace();
		Garage newGarage = new Garage();
		newGarage.setId(1L);
		newParkingSpace.setGarage(newGarage);
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
	void getVehiclesByMakeNameTest() {
		List<Vehicle> vehicles = this.vehicleService.getVehiclesByMakeName("ferrari");
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
	void getParkingSpaceByUserIdTest() {
		ParkingSpace parkingSpace = this.userService.getParkingSpaceByUserId(2L);
		assertEquals(33, parkingSpace.getNumber());
	}

	@Test
	void getUsernameByEmailTest() {
		User user = this.userService.getUserByEmail("jane.parker@example.com");
		assertEquals("Jane", user.getFirstName());
	}
}
