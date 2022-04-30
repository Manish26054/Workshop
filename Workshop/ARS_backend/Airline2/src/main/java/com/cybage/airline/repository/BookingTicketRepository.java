package com.cybage.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.airline.entity.BookTicket;

@Repository
public interface BookingTicketRepository extends JpaRepository<BookTicket, Integer>{
	
}
