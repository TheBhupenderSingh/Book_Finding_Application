package com.example.ApacheDerby.apacheDerby.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApacheDerby.apacheDerby.Customer.Customer;
import com.example.ApacheDerby.apacheDerby.Customer.Product;
import com.example.ApacheDerby.apacheDerby.dto.CustomerDto;
import com.example.ApacheDerby.apacheDerby.service.toService;


@CrossOrigin( origins = "http://localhost:3000")
@RestController
public class ToController {
	
	@Autowired
	toService toservice ;
	
/*1 Getting All Customers Details*/
	@RequestMapping("/customer")
	public List<Customer> getAllTo(){
		return toservice.getAllTo();	
	}
/*3 Getting Customer By ID*/
	@RequestMapping("/customer/{id}")
	public Customer getTo(@PathVariable Integer id) {
		return toservice.getById(id);
	}
/*2 Creating Customer*/
	@RequestMapping(method=RequestMethod.POST ,value="/customer")
	public void createTo(@RequestBody Customer c) {
		toservice.createTo(c);
	}
/*4 Updating Customer Details*/
	@RequestMapping(method=RequestMethod.PUT ,value="/customer/{id}")
	public void updateTo(@PathVariable Integer id ,@RequestBody Customer c) {
		toservice.upadateTo(id, c);
	}
/*5 Deleting Customer Details*/
	@RequestMapping(method=RequestMethod.DELETE ,value="/customer/{id}")
	public void deleteTo(@PathVariable Integer id ) {
		toservice.deleteTo(id);
	}
/*6 Creating Product inside the customer*/
	@RequestMapping(method=RequestMethod.POST , value="/customer/{id}/product" )
	public void createProduct(@RequestBody Product p , @PathVariable Integer id) {
		toservice.createProduct(id, p);
	}
/*7 Getting All the Products irrespective of Customer*/
	@RequestMapping(method=RequestMethod.GET ,value="/product")
	public List<Product> findAllProducts(){
		return toservice.findAllProducts();
	}
	
	
/*8 Getting All the Products respective of Customer Address*/
	@RequestMapping(method=RequestMethod.GET ,value="/product/{address}")
	public List<Product> findAllProductsInRange(@PathVariable("address") String Address){
		return toservice.findAllProductsInRange(Address) ;
	}


/*9 Searching Specific Book in near address*/
	@RequestMapping(method=RequestMethod.GET ,value="/product/{address}/{bookName}")
    public List<Customer> findCustOfSameAddSameBook(@PathVariable("address") String address ,@PathVariable("bookName") String bookName){
		return toservice.findCustOfSameAddSameBook(address, bookName);
    }
    	
    
}
   




