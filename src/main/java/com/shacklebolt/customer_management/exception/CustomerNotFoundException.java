package com.shacklebolt.customer_management.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message){
        super(message);
        System.out.println("Exception : "+message+"!!!!");
    }
}
