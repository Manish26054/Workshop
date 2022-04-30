package com.cybage.airline.model;

import org.springframework.beans.BeanUtils;

import com.cybage.airline.entity.BookTicket;
import com.cybage.airline.entity.Discount;
import com.cybage.airline.entity.Flight;

public class Discountdto {

	private int discountId;
	private int userId;
	private int bookingId;
	private int flightId;
	private String passangerName1;
	private String passangerName2;
	private String passangerName3;
	private int totalPassenger;
	private String returnDate;
	private double totalAmount;
	
	public Discountdto() {
		// TODO Auto-generated constructor stub
	}

	public Discountdto(int discountId, int userId, int bookingId, int flightId, String passangerName1, String passangerName2,
			String passangerName3, int totalPassenger, String returnDate, double totalAmount) {
		super();
		this.discountId = discountId;
		this.userId = userId;
		this.bookingId = bookingId;
		this.flightId = flightId;
		this.passangerName1 = passangerName1;
		this.passangerName2 = passangerName2;
		this.passangerName3 = passangerName3;
		this.totalPassenger = totalPassenger;
		this.returnDate = returnDate;
		this.totalAmount = totalAmount;
	}

	

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getPassangerName1() {
		return passangerName1;
	}

	public void setPassangerName1(String passangerName1) {
		this.passangerName1 = passangerName1;
	}

	public String getPassangerName2() {
		return passangerName2;
	}

	public void setPassangerName2(String passangerName2) {
		this.passangerName2 = passangerName2;
	}

	public String getPassangerName3() {
		return passangerName3;
	}

	public void setPassangerName3(String passangerName3) {
		this.passangerName3 = passangerName3;
	}

	public int getTotalPassenger() {
		return totalPassenger;
	}

	public void setTotalPassenger(int totalPassenger) {
		this.totalPassenger = totalPassenger;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	
	
	@Override
	public String toString() {
		return "Offerdto [offerId=" + discountId + ", userId=" + userId + ", bookingId=" + bookingId + ", flightId="
				+ flightId + ", passangerName1=" + passangerName1 + ", passangerName2=" + passangerName2
				+ ", passangerName3=" + passangerName3 + ", totalPassenger=" + totalPassenger + ", returnDate="
				+ returnDate + ", totalAmount=" + totalAmount + "]";
	}

	public static BookTicket toOfferModel(Discountdto dto)
	{
		BookTicket entity= new BookTicket();
		BeanUtils.copyProperties(dto, entity);
		
		Flight flight = new Flight();
		flight.setFlightId(dto.getFlightId());
		entity.setFlight(flight);
		
		
		Discount discount = new Discount();
		discount.setDiscountId(dto.getDiscountId());
		entity.setDiscount(discount);
			
		return entity;
	}
}
