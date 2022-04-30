package com.cybage.airline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.airline.entity.Discount;
import com.cybage.airline.entity.Flight;
import com.cybage.airline.exception.InputEmptyException;
import com.cybage.airline.exception.InvalidInputProvidedException;
import com.cybage.airline.exception.RecordNotFoundException;
import com.cybage.airline.service.DiscountService;
import com.cybage.airline.service.FlightService;

//import com.sun.org.slf4j.internal.Logger;



@RestController
@RequestMapping("/flight")
@CrossOrigin("http://localhost:4200/")
public class FlightController {

	Logger logger = LoggerFactory.getLogger(FlightController.class);
	@Autowired
	FlightService flightservice;

	@Autowired
	DiscountService discountservice;
	
	// FLIGHT CONTROLLER
	@PostMapping("/addFlight")
	public ResponseEntity<String> addFlight(@RequestBody(required = false) Flight flight)
			throws InvalidInputProvidedException, InputEmptyException {
		logger.info("AddFlight Controller was called");
		if (flight.getFlightName().isEmpty() || flight.getFlightName().length() == 0) {
			throw new InputEmptyException("Input field are empty");

		}

		if (flight.getFlightId() <= 0 || flight.getPrice() <= 0 || flight.getCapacity() <= 0) {
			throw new InvalidInputProvidedException("Invalid Input");
		}
		flightservice.addFlight(flight);
		return new ResponseEntity<String>("Flight Added Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getFlight")
	public ResponseEntity<List<Flight>> getFlight() throws RecordNotFoundException {
		logger.info("GETFlight Controller was called");
		List<Flight> list = flightservice.getFlight();
		if (list.isEmpty()) {
			throw new RecordNotFoundException("No Flights Found");
		}

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getFlightById/{id}")
	public Flight getById(@PathVariable int id) throws RecordNotFoundException {
		logger.info("GET FlightBy Id Controller was called");

		Flight flight = flightservice.getById(id);
		if (flight == null) {
			throw new RecordNotFoundException("Flight Not Found");
		}
		return flight;

	}

	@DeleteMapping("/deleteFlight/{id}")
	public ResponseEntity<String> deleteFlight(@PathVariable int id) throws InvalidInputProvidedException {
		logger.info("DeleteFlight Controller was called");

		if (id <= 0) {
			throw new InvalidInputProvidedException("Invalid Id");
		}

		flightservice.deleteFlight(id);
		return new ResponseEntity<String>("Flight Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/editFlight/{id}")
	public ResponseEntity<String> updateFlight(@PathVariable int id, @RequestBody Flight flight)
			throws InputEmptyException, InvalidInputProvidedException {
		logger.info("EditFlight Controller was called");
		if (flight.getFlightName().isEmpty() || flight.getFlightName().length() == 0) {
			throw new InputEmptyException("Input field are empty");
		}

		if (flight.getFlightId() <= 0 || flight.getPrice() <= 0 || flight.getCapacity() <= 0) {
			throw new InvalidInputProvidedException("Invalid Input");
		}
		flightservice.updateFlight(flight);
		return new ResponseEntity<String>("Flight Updated Successfully", HttpStatus.OK);

	}

	@GetMapping("/getFlightByName/{flightName}")
	public List<Flight> getByFlightName(@PathVariable String flightName) throws RecordNotFoundException {
		logger.info("GETFlightBYNAME Controller was called");

		List<Flight> flight = flightservice.getFlightByName(flightName);
		if (flight == null) {
			throw new RecordNotFoundException("Not Found");
		}
		return flight;

	}

	@GetMapping("/getFlightByDeparture")
	public List<Flight> getByDeparture(@RequestParam int start, int end) throws RecordNotFoundException {
		logger.info("GETFlightBYDeparture Controller was called");

		List<Flight> flight = flightservice.getFlightByDepartureTime(start, end);
		if (flight == null) {
			throw new RecordNotFoundException("Not Found");
		}
		return flight;

	}

	@GetMapping("/searchFlight")
	public List<Flight> searchFlight(@RequestParam String source, String destination, String date)
			throws RecordNotFoundException {
		logger.info("SearchFlight Controller was called");
		List<Flight> flight = flightservice.searchFlight(source, destination, date);
		if (flight == null) {
			throw new RecordNotFoundException("Not Found");
		}
		return flight;

	}

	@GetMapping("/FlightByMorning")
	public ResponseEntity<List<Flight>> FlightByMorning() throws RecordNotFoundException {
		logger.info("FlightByMorning Controller was called");
		List<Flight> list = flightservice.FlightByMorning();
		if (list == null) {
			throw new RecordNotFoundException("Not Found");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/FlightByNoon")
	public ResponseEntity<List<Flight>> FlightByNoon() throws RecordNotFoundException {
		logger.info("FlightByNoon Controller was called");
		List<Flight> list = flightservice.FlightByNoon();
		if (list == null) {
			throw new RecordNotFoundException("Not Found");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/FlightByEvening")
	public ResponseEntity<List<Flight>> FlightByEvening() throws RecordNotFoundException {
		logger.info("FlightByEvening Controller was called");
		List<Flight> list = flightservice.FlightByEvening();
		if (list == null) {
			throw new RecordNotFoundException("Not Found");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/FlightByNight")
	public ResponseEntity<List<Flight>> FlightByNight() throws RecordNotFoundException {
		logger.info("FlightByNight Controller was called");
		List<Flight> list = flightservice.FlightByNight();
		if (list == null) {
			throw new RecordNotFoundException("Not Found");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// -------------
	// DISCOUNT CONTROLLER
	// ------

	@PostMapping("/addDiscount")
	public ResponseEntity<String> addDiscount(@RequestBody(required = false) Discount discount)
			throws InputEmptyException, InvalidInputProvidedException {
		logger.info("addDiscount Controller was called");
		if (discount.getDiscountName().isEmpty() || discount.getDiscountName().length() == 0) {
			throw new InputEmptyException("Input field are empty");
		}

		if (discount.getDiscountId() <= 0 || discount.getDiscountPrice() <= 0) {
			throw new InvalidInputProvidedException("Invalid Input");
		}

		discountservice.addDiscount(discount);
		return new ResponseEntity<String>("discount Added Successfully", HttpStatus.CREATED);
	}

	@GetMapping("/getDiscount")
	public ResponseEntity<List<Discount>> getDiscount() throws RecordNotFoundException {
		logger.info("getDiscount Controller was called");
		List<Discount> list = discountservice.getDiscount();
		if (list == null) {
			throw new RecordNotFoundException("Not Found");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/getDiscountById/{id}")
	public Discount getDiscountById(@PathVariable int id) throws RecordNotFoundException {
		logger.info("GET discounttBy Id Controller was called");

	
		Discount discount=discountservice.getDiscountById(id);
		if (discount == null) {
			throw new RecordNotFoundException("Flight Not Found");
		}
		return discount;

	}


	@DeleteMapping("/deleteDiscount/{id}")
	public ResponseEntity<String> deleteDiscount(@PathVariable int id) throws InvalidInputProvidedException {
		logger.info("deleteDiscount Controller was called");
		if (id <= 0) {
			throw new InvalidInputProvidedException("Invalid Id");
		}
		discountservice.deleteDiscount(id);
		return new ResponseEntity<String>("Discount Deleted Successfully", HttpStatus.OK);
	}

	@PutMapping("/editDiscount/{id}")
	public ResponseEntity<String> updateDiscount(@PathVariable int id, @RequestBody Discount discount)
			throws InputEmptyException, InvalidInputProvidedException {
		logger.info("editDiscount Controller was called");
		if (discount.getDiscountName().isEmpty() || discount.getDiscountName().length() == 0) {
			throw new InputEmptyException("Input field are empty");
		}

		if (discount.getDiscountId() <= 0 || discount.getDiscountPrice() <= 0) {
			throw new InvalidInputProvidedException("Invalid Input");
		}
		discountservice.updateDiscount(discount);
		return new ResponseEntity<String>("Discount Updated Successfully", HttpStatus.OK);

	}
}
