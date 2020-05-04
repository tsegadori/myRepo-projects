package com.coders.DressStore.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coders.DressStore.Entity.ProductsView;

@Repository
public class ProductsViewDaoImpl implements ProductsViewDao {

	@Autowired
	EntityManager em;
	
	public List<ProductsView> getAllProductsView() {
		List<ProductsView> productsView = em.createQuery(
					"SELECT p "
							+ "FROM ProductsView p", ProductsView.class).getResultList();
		return productsView;	
	}

}
