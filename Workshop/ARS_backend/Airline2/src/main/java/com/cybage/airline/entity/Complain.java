package com.cybage.airline.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_complain")
public class Complain
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complainId;
	
	private String complainDetail;
	private String complainStatus;
	private String  complainIssue;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
	private User user;
	
	public Complain() {
		
	}

	public Complain(int complainId, String complainDetail, String complainStatus, String complainIssue, User user) {
		super();
		this.complainId = complainId;
		this.complainDetail = complainDetail;
		this.complainStatus = complainStatus;
		this.complainIssue = complainIssue;
		this.user = user;
	}

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public String getComplainDetail() {
		return complainDetail;
	}

	public void setComplainDetail(String complainDetail) {
		this.complainDetail = complainDetail;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}

	public String getComplainIssue() {
		return complainIssue;
	}

	public void setComplainIssue(String complainIssue) {
		this.complainIssue = complainIssue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Complain [complainId=" + complainId + ", complainDetail=" + complainDetail + ", complainStatus="
				+ complainStatus + ", complainIssue=" + complainIssue + ", user=" + user + "]";
	}

	
	

}//main
