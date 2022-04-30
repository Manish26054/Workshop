package com.cybage.airline.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "bookTicket")
@JsonIgnoreProperties(value = {"flight","user","offer","handler","hibernateLazyInitializer"},allowSetters = true)
public class BookTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	//User should have atleast 2 characters
	@Size(min = 2, message = "Passenger should have atleast 2 characters.")
	private String passangerName1;
	@Size(min = 2, message = "Passenger should have atleast 2 characters.")
	private String passangerName2;
	@Size(min = 2, message = "Passenger should have atleast 2 characters.")
	private String passangerName3;
	private int totalPassenger;
	private String returnDate;
	private double totalAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JoinColumn(name = "flightId")
	private Flight flight;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JoinColumn(name = "userId")
	private User user;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "discountId")
	private Discount discount;
	
	

	
	
	public BookTicket() {
		
	}


	public BookTicket(int bookingId, String passangerName1,
			String passangerName2, String passangerName3, int totalPassenger, String returnDate, double totalAmount) {

		this.bookingId = bookingId;
		this.passangerName1 = passangerName1;
		this.passangerName2 = passangerName2;
		this.passangerName3 = passangerName3;
		this.totalPassenger = totalPassenger;
		this.returnDate = returnDate;
		this.totalAmount = totalAmount;
	}





	public int getBookingId() {
		return bookingId;
	}





	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}





	public Flight getFlight() {
		return flight;
	}





	public void setFlight(Flight flight) {
		this.flight = flight;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
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
	
	public Discount getDiscount() {
		return discount;
	}


	public void setDiscount(Discount discount) {
		this.discount = discount;
	}


	@Override
	public String toString() {
		return "BookTicket [bookingId=" + bookingId + ", passangerName1=" + passangerName1 + ", passangerName2="
				+ passangerName2 + ", passangerName3=" + passangerName3 + ", totalPassenger=" + totalPassenger
				+ ", returnDate=" + returnDate + ", totalAmount=" + totalAmount + ", flight=" + flight + ", user="
				+ user + ", discount=" + discount + "]";
	}

	
	

}
