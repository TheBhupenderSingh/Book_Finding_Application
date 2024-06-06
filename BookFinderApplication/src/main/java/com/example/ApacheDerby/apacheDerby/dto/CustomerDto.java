package com.example.ApacheDerby.apacheDerby.dto;

import java.util.List;

import com.example.ApacheDerby.apacheDerby.Customer.Product;

public class CustomerDto {
	
	private Integer id ;
	private String name;
	private String address;
	private int number;
	private List<ProductDto> productDto;
	
	
	
	
	public CustomerDto() {
		super();
	}
	
	public CustomerDto(Integer id, String name, String address, int number , List<ProductDto> productDto ) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.productDto = productDto ;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public List<ProductDto> getProductDto() {
		return productDto;
	}

	public void setProductDto(List<ProductDto> productDto) {
		this.productDto = productDto;
	}
	
	

}
