package com.shacklebolt.customer_management.doa;

import com.shacklebolt.customer_management.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDOA extends CrudRepository<Customer,Integer> {

}
