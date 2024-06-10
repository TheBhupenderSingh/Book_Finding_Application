package com.example.ApacheDerby.apacheDerby;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ApacheDerby.apacheDerby.Customer.Customer;
import com.example.ApacheDerby.apacheDerby.Repository.Repo;
import com.example.ApacheDerby.apacheDerby.Repository.toRepository;
import com.example.ApacheDerby.apacheDerby.dto.CustomerDto;
import com.example.ApacheDerby.apacheDerby.service.toService;

@SpringBootTest
class ApacheDerbyApplicationTests {

	
	@Mock
	Repo repo;
	
	
	@InjectMocks
	toService toservice = new toService() ;
	
	
	@Test
	void contextLoads() throws Exception {
		
		CustomerDto c  = new CustomerDto();
		c.setId(1);
		c.setNumber(35);
		
		Mockito.when(repo.getCustomerLoginByLoginName(1)).thenReturn(c);
		
		Assertions.assertEquals("sucess",toservice.authenticateCustomer(c) );
		
	}

	@Test
	void wrongContext () throws Exception{
		
		CustomerDto c = new CustomerDto();
		c.setId(1);
		c.setNumber(35);
		
		CustomerDto fromrepo  = new CustomerDto();
		fromrepo.setId(1);
		fromrepo.setNumber(36);
		
		Mockito.when(repo.getCustomerLoginByLoginName(1)).thenReturn(fromrepo);
		
		Exception e = Assertions.assertThrows(Exception.class,()-> toservice.authenticateCustomer(c));
		
		Assertions.assertEquals("Galt he", e.getMessage());
		
	}
	
	
	

}

		