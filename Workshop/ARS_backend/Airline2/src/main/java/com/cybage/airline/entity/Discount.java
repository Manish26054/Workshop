package com.cybage.airline.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="discount")
@JsonIgnoreProperties(value= {"ticket","handler","hibernateLazyInitializer"})
public class Discount {
@Id
private int discountId;
private String discountName;
private int discountPrice;
private String discountCode;


@OneToMany(mappedBy="discount", cascade=CascadeType.ALL)
private List<BookTicket> ticket;


public Discount() {
	super();
	// TODO Auto-generated constructor stub
}
public int getDiscountId() {
	return discountId;
}
public void setDiscountId(int discountId) {
	this.discountId = discountId;
}
public String getDiscountName() {
	return discountName;
}
public void setDiscountName(String discountName) {
	this.discountName = discountName;
}
public int getDiscountPrice() {
	return discountPrice;
}
public void setDiscountPrice(int discountPrice) {
	this.discountPrice = discountPrice;
}
public String getDiscountCode() {
	return discountCode;
}
public void setDiscountCode(String discountCode) {
	this.discountCode = discountCode;
}
public Discount(int discountId, String discountCode, String discountName, int discountPrice) {
	super();
	this.discountId = discountId;
	this.discountCode = discountCode;
	this.discountName = discountName;
	this.discountPrice = discountPrice;
}
@Override
public String toString() {
	return "Discount [discountId=" + discountId + ", discountName=" + discountName + ", discountPrice=" + discountPrice
			+ ", discountCode=" + discountCode + ", ticket=" + ticket + "]";
}

}
