package com.coders.DressStore.Dao;

import java.util.List;

import com.coders.DressStore.Entity.Product;

public interface ProductsDao {

	List<Product> getProductsList();
	Product getProduct(int id);
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product prouct);
}
