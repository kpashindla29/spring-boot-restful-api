package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.Customer;
import com.ab.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	// Write Business methods/logic
	
	public Customer saveCustomer(Customer customer) {
		
		return this.customerRepository.save(customer);
		
	}
	
	
	public List<Customer> loadCustomers(){
		return this.customerRepository.findAll();
	}
	
	
	public List<Customer> loadCustomersByCustomerName(String customerName){
		return this.customerRepository.getCustomersByCustomerName(customerName);
	}


	public int updateCustomerDataById(Customer customer) {
		return this.customerRepository.updateCustomerNameById(customer.getCustomerName(), customer.getCustomerId());
	}


	public int deleteCustomerById(int customerId) {
		return this.customerRepository.deleteCustomerById(customerId);
	}
	
}
