package com.coder.computerStore.ComputerStore.Service;

import java.util.List;

import com.coder.computerStore.ComputerStore.Entity.Manufacturer;
import com.coder.computerStore.ComputerStore.Entity.Product;

public interface ServiceDao {
	List<Product> listProducts();
	Product getProduct(Integer code);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	void addProduct(Product product);
	List<Manufacturer> listManufacturers();
	Manufacturer getManufacturer(Integer code);
	void updateManufacturer(Manufacturer manufacturer);
	void deleteManufacturer(Manufacturer manufacturer);
	void addManufacturer(Manufacturer manufacturer);
}
