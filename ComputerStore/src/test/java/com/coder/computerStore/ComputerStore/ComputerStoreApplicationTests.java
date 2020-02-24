package com.coder.computerStore.ComputerStore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coder.computerStore.ComputerStore.DAO.ManufacturerDao;
import com.coder.computerStore.ComputerStore.DAO.ProductDao;
import com.coder.computerStore.ComputerStore.Entity.Manufacturer;
import com.coder.computerStore.ComputerStore.Entity.Product;

@SpringBootTest
class ComputerStoreApplicationTests {

	@Autowired 
	ProductDao pdi;
	
	@Autowired
	ManufacturerDao mdi;
	/*
	@Test
	void contextLoads() {
		List<Product> products = pdi.listProducts();
		for(int i=0; i<products.size(); i++) {
		System.out.println(i+1+". "+products.get(i).getName()+
				", Manufacturer:- "+products.get(i).getManufacturerCode().getName());
	}
	}

	@Test
	void manufacturerTest() {
		List<Manufacturer> manufacturers = mdi.listManufacturers();
		for(int i=0; i<manufacturers.size(); i++) {
		System.out.println(i+1+". "+manufacturers.get(i).getName());
		}
	}
	*/
	@Test
	void contextLoads() {
 			Product p = new Product();
 			Manufacturer m = new Manufacturer();
 			m = mdi.getManufacturer(5);
			p.setName("Flash Disk");
			p.setPrice(25.00);
			p.setManufacturerCode(m);
			pdi.addProduct(p);
	}
}
