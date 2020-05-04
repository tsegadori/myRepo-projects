package com.coders.DressStore.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coders.DressStore.Dao.ProductsDao;
 import com.coders.DressStore.Dao.ProductsImageDao;
import com.coders.DressStore.Dao.ProductsViewDao;
import com.coders.DressStore.Entity.Product;
import com.coders.DressStore.Entity.ProductsImages;
import com.coders.DressStore.Entity.ProductsView;
import com.stripe.Stripe;
import com.stripe.model.Charge;

@Service
@Transactional
public class ServiceDaoImpl implements ServiceDao{

	@Autowired
	ProductsDao productsDao;
	
	@Autowired
	ProductsImageDao productsImageDao;
	
	@Autowired
	ProductsViewDao productsView;
	
	@Override
	public List<Product> getProductsList() {
		return productsDao.getProductsList();
	}

	@Override
	public Product getProduct(int id) {
		return productsDao.getProduct(id);
	}

	@Override
	public List<ProductsImages> getProductImagesList() {
 		return productsImageDao.getProductImagesList();
	}

	@Override
	public ProductsImages getProductImage(int id) {
 		return productsImageDao.getProductImage(id);
	}

	@Override
	public List<ProductsView> getAllProductsView() {
		return productsView.getAllProductsView();
	}
	
}
