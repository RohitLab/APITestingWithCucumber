package com.rg.PayLoad;

import com.rg.pojo.CreateCustomerPojo;

public class TestPayLoad {
	
	
	public CreateCustomerPojo setData(String firstname , String lastname){
		CreateCustomerPojo createCustomerPojo = new CreateCustomerPojo();
		createCustomerPojo.setFirstname(firstname);
		createCustomerPojo.setLastname(lastname);
		return createCustomerPojo;
		
	}
	
}
