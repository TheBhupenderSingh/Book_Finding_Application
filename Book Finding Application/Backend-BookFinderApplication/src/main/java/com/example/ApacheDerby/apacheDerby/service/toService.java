package com.example.ApacheDerby.apacheDerby.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApacheDerby.apacheDerby.Customer.Customer;
import com.example.ApacheDerby.apacheDerby.Customer.Product;
import com.example.ApacheDerby.apacheDerby.Repository.Repo;
import com.example.ApacheDerby.apacheDerby.Repository.toRepository;
import com.example.ApacheDerby.apacheDerby.dto.CustomerDto;

@Service
@Transactional
public class toService {
	
	@Autowired
	toRepository torepository;
	
	@Autowired
	Repo repo;
	
/*1 Getting All Customers Details*/
	public List<Customer> getAllTo(){
		List<Customer> n = new ArrayList<>();
		torepository.findAll().forEach(x -> n.add(x));
		return n;
	}
/*2 Creating Customer*/
	public void createTo (Customer c) {
		torepository.save(c);
	}
/*3 Getting Customer By ID*/
	public Customer getById(Integer id) {
		return torepository.findById(id).get();
	}
/*4 Updating Customer Details*/
	public void upadateTo(Integer id ,Customer c) {
		torepository.save(c);
	}
/*5 Deleting Customer Details*/
	public void deleteTo(Integer id) {
		torepository.deleteById(id);
	}
/*6 Creating Product inside the customer*/
	public void createProduct(Integer id , Product product) {
		torepository.findById(id).get().getProducts().add(product);	
	}
/*7 Getting All the Products irrespective of Customer*/
	public List<Product> findAllProducts() {
		List<Product> n =  new ArrayList<>();
		torepository.findAll().forEach(x-> n.addAll(x.getProducts()));
		return n;
	}
/*8 Getting All the Products respective of Customer Address*/
	public List<Product> findAllProductsInRange(String address){
		List<Product> n =  new ArrayList<>();
		List<Customer> p = new ArrayList<>();
		torepository.findAll().forEach(x-> p.add(x));
		
	/*	p.stream().filter(x-> x.getAddress().equals(address)).forEach(x-> n.addAll(x.getProducts()));*/
		
		for(int i=0 ; i<p.size() ; i++) {
			if(p.get(i).getAddress().equals(address)) {
				n.addAll(p.get(i).getProducts());
			}
		}
		
		return n;	
	}
/*9 Searching Specific Book in near address*/
	public List<Customer> findCustOfSameAddSameBook(String address , String bookName){
		List<Customer> r = new ArrayList<>();
		List<Customer> q = new ArrayList<>();
		List<Customer> p = new ArrayList<>();
		torepository.findAll().forEach(x-> p.add(x));
		p.stream().filter(x-> x.getAddress().equals(address)).forEach(x->q.add(x));
		for(int i =0 ; i<q.size() ; i++) {
			for(int j=0 ; j<q.get(i).getProducts().size() ; j++)
			{ if(q.get(i).getProducts().get(j).getBookName().equalsIgnoreCase(bookName)) {
					r.add(q.get(i));
			}	
			}
	}
		return r;
	}


	
	
/*10 Authenticators*/
    public String authenticateCustomer (CustomerDto dto) throws Exception{
		
		String toret = null ;
		
		CustomerDto c = repo.getCustomerLoginByLoginName(dto.getId());
		
		
		 if(c.getNumber() == dto.getNumber()) {
			 toret = "sucess" ;
		 }
		 
		 else {
			 toret = null;
			 throw new Exception("Galt he");
		 }
		 
		 return toret ;
		 
		
	}
}

