package com.shacklebolt.customer_management.service;

import com.shacklebolt.customer_management.doa.CustomerDOA;
import com.shacklebolt.customer_management.exception.CustomerNotFoundException;
import com.shacklebolt.customer_management.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDOA customerDOA;

    //Add a customer to the data storage
    public Customer addCustomer(Customer customer){

        //save() is used for both insert and update operations
        customerDOA.save(customer);
        return customer;
    }

    //Return the list of Customers
    public List<Customer> getCustomers(){
        return (List<Customer>) customerDOA.findAll();
    }

    //return the Customer object associated with customerId
    public Customer getCustomer(int customerId){
        Optional<Customer> customer = customerDOA.findById(customerId);
        if(!customer.isPresent()) {
            throw new CustomerNotFoundException("Customer record with id : "+customerId+" , not found");
        }

        return customer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer){

        //If the passing object conatains id then save() will update the record with new data, if id is not assigned then save() will perform insert operation
        customer.setCustomerId(customerId);
        return customerDOA.save(customer);

    }

    public void deleteCustomer(int customerId){
        customerDOA.deleteById(customerId);

    }

}
