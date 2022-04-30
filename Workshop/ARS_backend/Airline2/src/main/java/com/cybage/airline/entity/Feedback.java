package com.cybage.airline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feebackId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	private String feedbackDetails;
	
	private int rating;
	
	
	public Feedback() {}


	public Feedback(int feebackId, User user, String feedbackDetails, int rating) {
		super();
		this.feebackId = feebackId;
		this.user = user;
		this.feedbackDetails = feedbackDetails;
		this.rating = rating;
	}


	public Feedback(User user, String feedbackDetails, int rating) {
		super();
		this.user = user;
		this.feedbackDetails = feedbackDetails;
		this.rating = rating;
	}


	public int getFeebackId() {
		return feebackId;
	}


	public void setFeebackId(int feebackId) {
		this.feebackId = feebackId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getFeedbackDetails() {
		return feedbackDetails;
	}


	public void setFeedbackDetails(String feedbackDetails) {
		this.feedbackDetails = feedbackDetails;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Feedback [feebackId=" + feebackId + ", user=" + user + ", feedbackDetails=" + feedbackDetails
				+ ", rating=" + rating + "]";
	}
	
	
}
