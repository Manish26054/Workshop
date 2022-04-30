package com.cybage.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.airline.entity.Flight;
import com.cybage.airline.repository.FlightRepository;


@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;

	public void addFlight(Flight flight) {
		flightRepository.save(flight);
	}

	public List<Flight> getFlight() {
		return flightRepository.findAll();
	}

	public Flight getById(int id) {
		return flightRepository.findById(id).orElse(null);
	}

	public void deleteFlight(int id) {
		flightRepository.deleteById(id);
	}

	public void updateFlight(Flight flight) {
		flightRepository.save(flight);
	}

	public List<Flight> getFlightByName(String flightName) {
		return flightRepository.findByFlightName(flightName);
	}

	public List<Flight> getFlightByDepartureTime(int start, int end) {
		return flightRepository.findByDepartureTimeGreaterThanAndDepartureTimeLessThan(start, end);
	}

	public List<Flight> FlightByMorning() {
		return flightRepository.FlightByMorning();
	}

	public List<Flight> FlightByNoon() {
		return flightRepository.FlightByNoon();
	}

	public List<Flight> FlightByEvening() {
		return flightRepository.FlightByEvening();
	}

	public List<Flight> FlightByNight() {
		return flightRepository.FlightByNight();
	}
	public List<Flight> searchFlight(String source,String destination,String date) {
		return flightRepository.searchFlight(source, destination, date);
	}

}
