package com.example.ApacheDerby.apacheDerby.Repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.ApacheDerby.apacheDerby.dto.CustomerDto;

@Repository
public class Repo {
	
	public CustomerDto getCustomerLoginByLoginName(Integer c) {
		Map<Integer, Integer> customerCredentials = new HashMap<Integer, Integer>();
		customerCredentials.put(1, 34);
		customerCredentials.put(2, 44);
		customerCredentials.put(3, 54);
		customerCredentials.put(4, 64);
		CustomerDto customerLogin = new CustomerDto();
		customerLogin.setId(c);
		customerLogin.setNumber(customerCredentials.get(c));
		return customerLogin;
		
	}

}
