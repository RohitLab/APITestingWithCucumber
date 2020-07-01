package com.Aress.PayLoad;

import com.Aress.pojo.CreateCustomerPojo;

public class TestPayLoad {
	
	
	public CreateCustomerPojo setData(String firstname , String lastname){
		CreateCustomerPojo createCustomerPojo = new CreateCustomerPojo();
		createCustomerPojo.setFirstname(firstname);
		createCustomerPojo.setLastname(lastname);
		return createCustomerPojo;
		
	}
	
}
