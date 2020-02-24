package com.coder.computerStore.ComputerStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coder.computerStore.ComputerStore.Entity.Manufacturer;
import com.coder.computerStore.ComputerStore.Entity.Product;
import com.coder.computerStore.ComputerStore.Service.ServiceDao;
//http://localhost:4200
@RestController
@CrossOrigin(origins="*")
public class AppRestController {

	@Autowired
	ServiceDao serviceDao;
	
	@PostMapping("/api/products")
	void addProduct(@RequestBody Product product) {
		serviceDao.addProduct(product); 	
	}
	
	@GetMapping("/api/products/{id}")
	Product getProduct(@PathVariable("id") Integer id) {
		return serviceDao.getProduct(id);
	}
	
	@GetMapping("/api/products")
	List<Product> getProducts() {
		return serviceDao.listProducts();
	}
	
	@PutMapping("/api/products")
	void updateProduct(@RequestBody Product product) {
		serviceDao.updateProduct(product); 	
 	}
	
	@DeleteMapping("/api/products/{id}")
	void deleteProduct(@PathVariable("id") int id) {
		Product product = serviceDao.getProduct(id);
		serviceDao.deleteProduct(product);;
	}
	
	@PostMapping("/api/manufacturers")
	void addProduct(@RequestBody Manufacturer manufacturer) {
		serviceDao.addManufacturer(manufacturer); 	
	}
	
	@GetMapping("/api/manufacturers/{code}")
	Manufacturer getManufacturer(@PathVariable int code) {
		return serviceDao.getManufacturer(code);
 	}
	
	@GetMapping("/api/manufacturers")
	List<Manufacturer> getManufacturers() {
		return serviceDao.listManufacturers();
	}
	
	@PutMapping("/api/manufacturers")
	void updateManufacturer(@RequestBody Manufacturer manufacturer) {
		serviceDao.updateManufacturer(manufacturer); 	
	}	
	
	@DeleteMapping("/api/manufacturers/{code}")
	void deleteManufacturer(@PathVariable int code) {
		Manufacturer manufacturer = serviceDao.getManufacturer(code);
		serviceDao.deleteManufacturer(manufacturer);	
	}
}
