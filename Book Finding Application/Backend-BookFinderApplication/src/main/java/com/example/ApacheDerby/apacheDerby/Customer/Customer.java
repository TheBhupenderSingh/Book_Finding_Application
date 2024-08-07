package com.example.ApacheDerby.apacheDerby.Customer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "customers")

public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id ;
	private String name;
	private String address;
	private float number;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "customer_product",
        joinColumns =@JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
	private List<Product> products;
	private String email ;
	private String password  ;

	public Customer() {}
	
	public Customer(Integer id, String name, String address, float number , List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.products = products ;
	}
	
	

	public List<Product> getProducts() {
		return products;
	}


	public void setProduct(List<Product> products) {
		this.products = products;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getNumber() {
		return number;
	}

	public void setNumber(float i) {
		this.number = i;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	

}

