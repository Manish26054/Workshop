package com.cybage.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.airline.entity.Flight;



@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

//	@Query(value="Select * from flight f where f.flight_name=:flight_name",nativeQuery=true)
//	List<Flight> findByFlightName(@Param("flight_name")String flight_name);
//
//	@Query(value="Select * from flight f where f.departure_time between start=:start AND end=:end",nativeQuery=true)
//	List<Flight> FlightByDeparture(@Param("start")String start,@Param("end")String end);

	List<Flight> findByFlightName(String flightName);

	List<Flight> findByDepartureTimeGreaterThanAndDepartureTimeLessThan(int start, int end);
	//http://localhost:8081/getFlightByDeparture?start=500&end=1999

	@Query(value = "Select * from flight f where f.departure_time between '0500' AND '1199'", nativeQuery = true)
	List<Flight> FlightByMorning();

	@Query(value = "Select * from flight f where f.departure_time between '1200' AND '1599'", nativeQuery = true)
	List<Flight> FlightByNoon();

	@Query(value = "Select * from flight f where f.departure_time between '1600' AND '1999'", nativeQuery = true)
	List<Flight> FlightByEvening();

	@Query(value = "Select * from flight f where (f.departure_time between '2000' AND '2400') OR (f.departure_time between '0' AND '0499') ", nativeQuery = true)
	List<Flight> FlightByNight();
	
	@Query(value = "Select * from flight f where f.source=?1 AND f.destination=?2 And f.date=?3",nativeQuery=true)
    List<Flight> searchFlight(String source, String destination,String date);
}
