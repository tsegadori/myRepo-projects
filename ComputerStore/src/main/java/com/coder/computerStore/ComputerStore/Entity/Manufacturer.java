package com.coder.computerStore.ComputerStore.Entity;

import javax.persistence.*;

@Entity
@Table(name="Manufacturers")
public class Manufacturer {

	@Id
	@Column(name="Code")
	private Integer code;
	@Column(name="Name")
	private String name;
	
	public Manufacturer() {
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
}
