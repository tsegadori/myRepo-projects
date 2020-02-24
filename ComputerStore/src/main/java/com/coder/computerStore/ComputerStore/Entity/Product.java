package com.coder.computerStore.ComputerStore.Entity;

import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Code")
	private Integer code;
	@Column(name="Name")
	private String name;
	@Column(name="Price")
	private Double price;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Manufacturercode", referencedColumnName="Code")
	private Manufacturer manufacturer;
	
	public Product() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Manufacturer getManufacturerCode() {
		return manufacturer;
	}

	public void setManufacturerCode(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}	
}
