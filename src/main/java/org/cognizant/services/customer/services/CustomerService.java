package org.cognizant.services.customer.services;


import java.util.List;
import org.springframework.stereotype.Service;

import org.cognizant.services.customer.controllers.CustomerController;
import org.cognizant.services.customer.entities.Customer;
import org.cognizant.services.customer.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	
//	private KafkaMessageProducer  producer;
	
	// INITIALIZE REPO
	private CustomerRepository customerRepository;
	//
	// CONSTRUCTOR
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	// SETTERS & GETTERS
	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}
	
	

//	public KafkaMessageProducer getProducer() {
//		return producer;
//	}
//
//	public void setProducer(KafkaMessageProducer producer) {
//		this.producer = producer;
//	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	// ADD CUSTOMER (CREATE)
	public Customer add(Customer customer) {
	
	customer =	customerRepository.save(customer);
		
		if (customer instanceof  Customer) {
			//producer
//			producer.sendCustomCustomer("userLogin", customer);
		}
		else {
			System.out.println("Customer does not exist");
		}
		
		
		return customer;
	}
		
	// FIND ALL CUSTOMERS (READ)
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	// FIND SPECIFIC CUSTOMER (READ)
	public Customer findSpecificCustomer(String customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	// UPDATE CUSTOMER
	public void update(String customerId, String companyName, String contactName, String street, String city,
			String state, int zipCode) {
		// CHECK IF CURRENT CUSTOMER EXISTS
		if (customerRepository.findById(customerId).isPresent()) {
			// FIND EXISTING CUSTOMER
			Customer existingCustomer = customerRepository.findById(customerId).get();
			// UPDATE VALUES
			existingCustomer.setCompanyName(companyName);
			existingCustomer.setContactName(contactName);
			existingCustomer.setStreet(street);
			existingCustomer.setCity(city);
			existingCustomer.setState(state);
			// SAVE UPDATED VALUES
			customerRepository.save(existingCustomer);
			
		}
		else {
			System.out.println("Customer does not exist");
		}
		
	}
	
	// DELETE CUSTOMER 
	public void delete(String customerId) {
		customerRepository.deleteById(customerId);
	}

	
	
}
