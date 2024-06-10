package com.example.ApacheDerby.apacheDerby;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ApacheDerby.apacheDerby.Customer.Customer;
import com.example.ApacheDerby.apacheDerby.Customer.Product;
import com.example.ApacheDerby.apacheDerby.Repository.toRepository;
import com.example.ApacheDerby.apacheDerby.service.toService;



@SpringBootApplication

public class ApacheDerbyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApacheDerbyApplication.class, args);
	
		
	}
	
	@Bean
    public CommandLineRunner demo(toRepository repository) {
        return (args) -> {
            // Add data to the repository
        	Customer a  = new Customer();
        	List<Product> aA = new ArrayList<>();
        	Product aOne = new Product(1,"Dune","Frank Herbert");
        	Product aTwo = new Product(2,"Jaws","Peter Benchley");
        	Product aThree = new Product(3,"Possession","A.S. Byatt");
        	Product aFour = new Product(4,"Misery" ,"Stephen King");
        	a.setAddress("Punjab");
        	a.setId(1);
        	a.setName("Ranveer");
        	a.setNumber(789566744);
        	aA.add(aThree);
        	aA.add(aFour);
        	a.setProduct(aA);
        	repository.save(a);
        	
        	Customer b  = new Customer();
        	b.setAddress("Delhi");
        	b.setId(2);
        	b.setName("Rajveer");
        	b.setNumber(736743990);
        	List<Product> bB = new ArrayList<>();
        	bB.add(aOne);
        	bB.add(aTwo);
        	b.setProduct(bB);
        	repository.save(b);
        	

          
        };
    }

}
