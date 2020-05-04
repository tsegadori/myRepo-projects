package com.coders.DressStore.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.DressStore.Entity.ProductsImages;

@Repository
public class ProductImageDaoImpl implements ProductsImageDao {

	@Autowired
	EntityManager em;
	
	@Override
	public List<ProductsImages> getProductImagesList() {
		List<ProductsImages> productsImages = em.createQuery(
				"SELECT pi "
				+ "FROM ProductsImages pi", ProductsImages.class).getResultList();
		return productsImages;
	}

	@Override
	public ProductsImages getProductImage(int id) {
		return em.find(ProductsImages.class, id);
	}

}
