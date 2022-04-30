package com.cybage.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.airline.entity.BookTicket;
import com.cybage.airline.repository.BookingTicketRepository;

import ch.qos.logback.classic.Logger;


@Service
public class BookingTicketService {
	
	Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(BookingTicketService.class);

	@Autowired
	BookingTicketRepository bookingTicketrepository;

	
	public void addBooking(BookTicket newBookTicket) 
	{
		logger.info("AddBooking service is called....");
		bookingTicketrepository.save(newBookTicket);
		
	}
	

	public List<BookTicket> getAllBookings() {
		
		logger.info("GetAllBooking service is called....");
		return bookingTicketrepository.findAll();
	}


	public BookTicket updateBookingById(int bookingId, BookTicket bookTicket) {
		
		logger.info("UpdateBooking service is called....");
		return bookingTicketrepository.save(bookTicket);
		
	}


	public Optional<?> getAllBookings(int bookingId) {
		Optional<?> bookticket = bookingTicketrepository.findById(bookingId); 
		logger.info("GetBooking by id service is called....");
		return bookticket;
	}


	public void deleteBookingById(int bookingId) {
		logger.info("DeleteBooking service is called....");
		bookingTicketrepository.deleteById(bookingId);
		
	}


	public Optional<?> getBookingByuserId(int userId) {
		// TODO Auto-generated method stub
		Optional<?> userbooking = bookingTicketrepository.findById(userId); 
		logger.info("getting bookings based on userid....");
		return userbooking;
	}
	


}
