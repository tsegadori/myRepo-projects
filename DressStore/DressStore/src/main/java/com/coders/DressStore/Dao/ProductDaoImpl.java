package com.coders.DressStore.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.DressStore.Entity.Product;

@Repository
public class ProductDaoImpl implements ProductsDao {

	@Autowired
	EntityManager em;
	
	@Override
	public List<Product> getProductsList() {
		List<Product> products = em.createQuery(
				"SELECT p "
				+ "FROM Product p", Product.class).getResultList();
		return products;
	}

	@Override
	public Product getProduct(int id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(Product prouct) {
		// TODO Auto-generated method stub

	}

}
