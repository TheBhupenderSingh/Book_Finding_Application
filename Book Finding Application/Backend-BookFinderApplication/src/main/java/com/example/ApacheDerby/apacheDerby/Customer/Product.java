package com.example.ApacheDerby.apacheDerby.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "products")
public class Product {
	
	@Id
	private Integer id ;
	private String bookName ;
	private String auther ;
	
	public Product() {}

	public Product(Integer id, String bookName, String auther) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.auther = auther;
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}
	
	
	
	
}
