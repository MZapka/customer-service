package org.cognizant.services.customer.controllers;

import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.cognizant.services.customer.entities.Customer;
import org.cognizant.services.customer.services.CustomerService;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@RestController
@RequestMapping("customers")
public class CustomerController {
	
	// INITIALIZE CUSTOMER SERVICE
	@Autowired
	private CustomerService customerService;
	
	// CONSTRUCTOR
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	// SETTERS & GETTERS
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	// CREATE CUSTOMER
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.add(customer);
	
	}
	
	// FIND ALL CUSTOMERS
	@GetMapping("/")	// localhost:8088/categories/allProducts
	public List<Customer> getAllCustomers(){
		return customerService.findAll();
	}
	
	// FIND SPECIFIC CUSTOMER
	@GetMapping("/findSpecificCustomer/{customerId}")
	public Customer findSpecificCustomer(@PathVariable("customerId") String customerId) {
		return customerService.findSpecificCustomer(customerId);
	}
	
	// UPDATE CUSTOMER
	@PutMapping("/updateCustomer/{customerId}")
	public void updateCustomer(@PathVariable("customerId") String customerId, String username, String password, String street, String city, String state, int zipcode) {
		customerService.update(customerId, username, password, street, city, state, zipcode);
	}
	
	// DELETE CUSTOMER
	@DeleteMapping("/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") String customerId) {
		customerService.delete(customerId);
	}
	


}
