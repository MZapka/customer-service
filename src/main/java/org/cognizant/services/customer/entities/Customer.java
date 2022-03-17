package org.cognizant.services.customer.entities;


import javax.persistence.*;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
	
	// INTIALIZE VARIABLES
	@Id	
	@JoinColumn(name="customer_id", referencedColumnName="CUSTOMERID")
	private String customerID;
	
	@Column(name="COMPANYNAME")
	private String companyName;
	
	@Column(name="CONTACTNAME")
	private String contactName;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	// DEFAULT CONSTRUCTOR
	public Customer() {}
	
	// CONSTRUCTOR
	public Customer(String companyName, String contactName, String street, String city,
			String state) {
		super();
		this.companyName = companyName;
		this.contactName = contactName;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	// SETTERS & GETTERS
	public String getCustomerId() {
		return customerID;
	}

	public void setCustomerId(String customerId) {
		this.customerID = customerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerID + ", username=" + companyName + ", password=" + contactName
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode=" + "]";
	}
}
