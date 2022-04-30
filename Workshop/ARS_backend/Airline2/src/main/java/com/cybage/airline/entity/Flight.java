package com.cybage.airline.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class Flight {
	@Id
	private int flightId;
	
	private String flightName;
	
	private String source;
	
	private String destination;
	
	private String date;

	private String departureTime;
	
	private String arrivalTime;
	
	private int capacity;
	
	private int price;
	
	private String stops;
	private String travelClass;

	@OneToMany(mappedBy="flight",cascade=CascadeType.ALL)
	private List<BookTicket> ticket;
	
	
	
	public Flight() {}
	
	public Flight(int flightId, String arrivalTime, int capacity, String date, String departureTime, String destination,
			String flightName, int price, String source,String stops,String travelClass) {
		super();
		this.flightId = flightId;
		this.arrivalTime = arrivalTime;
		this.capacity = capacity;
		this.date = date;
		this.departureTime = departureTime;
		this.destination = destination;
		this.flightName = flightName;
		this.price = price;
		this.source = source;
		this.stops=stops;
	}

	public int getFlightId() {
		return flightId;
	}
	
	
	public String getStops() {
		return stops;
	}

	public void setStops(String stops) {
		this.stops = stops;
	}

	public List<BookTicket> getTicket() {
		return ticket;
	}

	public void setTicket(List<BookTicket> ticket) {
		this.ticket = ticket;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", arrivalTime=" + arrivalTime + ", capacity=" + capacity + ", date="
				+ date + ", departureTime=" + departureTime + ", destination=" + destination + ", flightName="
				+ flightName + ", price=" + price + ", source=" + source + "]";
	}
}
