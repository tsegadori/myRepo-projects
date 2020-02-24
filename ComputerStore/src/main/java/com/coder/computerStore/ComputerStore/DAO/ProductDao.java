package com.coder.computerStore.ComputerStore.DAO;

import java.util.List;

import com.coder.computerStore.ComputerStore.Entity.Product;

public interface ProductDao {
	
	List<Product> listProducts();
	Product getProduct(Integer code);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	void addProduct(Product product);
}
