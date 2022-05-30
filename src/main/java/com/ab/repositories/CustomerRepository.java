package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ab.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public List<Customer> getCustomersByCustomerName(String customerName);
	
	@Query(value="SELECT * from customer",nativeQuery=true)
	public List<Customer> loadAllCustomers();
	
	// JPA format queries always use Entity name and its variables
	@Query(value="FROM Customer")
	public List<Customer> loadAllCustomers2();
	
	// UPDATE query in JPA format
	@Query("UPDATE Customer c SET c.customerName = :cName WHERE c.customerId = :cId")
	@Modifying
	@Transactional
	public int updateCustomerNameById(@Param("cName") String customerName,@Param("cId") int customerId);
	
	
	@Query("DELETE from Customer c WHERE c.customerId =  :customerId")
	@Modifying
	@Transactional
	public int deleteCustomerById(@Param("customerId") int customerId);
	
}
