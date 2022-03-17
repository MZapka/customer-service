package org.cognizant.services.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.cognizant.services.customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
		
}