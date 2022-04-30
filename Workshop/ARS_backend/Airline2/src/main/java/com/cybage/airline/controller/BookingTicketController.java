package com.cybage.airline.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.cybage.airline.entity.BookTicket;
import com.cybage.airline.exception.RecordNotFoundException;
import com.cybage.airline.model.Discountdto;
import com.cybage.airline.service.BookingTicketService;



@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/bookticket")
public class BookingTicketController {
	
	@Autowired
	BookingTicketService bookTicketService;
	
	//add new booking to database
	@PostMapping("/newBooking")
	public ResponseEntity<?> addBooking(@Valid @RequestBody Discountdto odto)
	{	
		BookTicket bookModel = Discountdto.toOfferModel(odto); 
		bookTicketService.addBooking(bookModel);
		return new ResponseEntity<String>("New booking added successfully.....",HttpStatus.CREATED);
	}

	//get all bookings from database
	@GetMapping("/getAllBookings")
	
	public ResponseEntity<List<BookTicket>> getAllBookings() throws RecordNotFoundException
	{
		List<BookTicket> list = bookTicketService.getAllBookings();
		
		if(list.isEmpty()) {
			throw new RecordNotFoundException("No data found....");
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	//update booking in database with bookingId
	@PutMapping("/updateBooking/{id}")
	public ResponseEntity<String> updateBookingById(@PathVariable int id,@RequestBody BookTicket bookTicket)
	{
		bookTicket.setBookingId(id);
		bookTicketService.updateBookingById(id,bookTicket);
		return new ResponseEntity<String>("Booking Details Updated Successfully....",HttpStatus.OK);
	}
	
	
	//get booking by bookingId.
	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<?> getBookingById(@PathVariable int bookingId) throws RecordNotFoundException
	{
		Optional<?> bookTicket = bookTicketService.getAllBookings(bookingId);
		
		if(bookTicket == null)
		{
			throw new RecordNotFoundException("No record found....");
		}
		
		return new ResponseEntity<>(bookTicket,HttpStatus.FOUND);
	}
	
	//get booking by userId.
		@GetMapping("/getUserBooking/{userId}")
		public ResponseEntity<?> getBookingByuserId(@PathVariable int userId) throws RecordNotFoundException
		{ 
			Optional<?> userbooking = bookTicketService.getBookingByuserId(userId);
			
			if(userbooking == null)
			{
				throw new RecordNotFoundException("No record found....");
			}
			
			return new ResponseEntity<>(userbooking,HttpStatus.FOUND);
		}

	
	//delete booking by bookingId.
	@DeleteMapping("/deleteBooking/{bookingId}")
	public ResponseEntity<String> deleteBookingById(@PathVariable int bookingId) throws RecordNotFoundException
	{
		bookTicketService.deleteBookingById(bookingId);
		if(bookingId <= 0 ) {
			throw new RecordNotFoundException("No reccord found....");
		}
		return new ResponseEntity<String>("Customer Deleted Succesfully.....",HttpStatus.OK);
	}	
}
