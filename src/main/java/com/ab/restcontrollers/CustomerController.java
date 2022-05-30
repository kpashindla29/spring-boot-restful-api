package com.ab.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.entities.Customer;
import com.ab.services.CustomerService;

@RestController
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	// Request Mapping methods or RESTful API end-points
	// CRUD operations
	// Create  
	@PostMapping("/customers/save")
	//@RequestMapping(value="/customers/save",method = RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer) {
	
		return this.customerService.saveCustomer(customer);
	
	}
	
	// READ
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		
		return this.customerService.loadCustomers();
	}
	
	// UPDATE
	@PutMapping("/customers/update_customer")
	public int updateCustomerDetails(@RequestBody Customer customer) {
		
		return this.customerService.updateCustomerDataById(customer);
		
	}
	
	// DELETE
	@DeleteMapping("/customers/{customerId}")
	public int deleteCustomerById(@PathVariable("customerId") int customerId) {
		
		return this.customerService.deleteCustomerById(customerId);
		
	}
	
}
