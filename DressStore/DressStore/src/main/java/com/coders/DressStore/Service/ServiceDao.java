package com.coders.DressStore.Service;

import java.util.List;

import com.coders.DressStore.Entity.Product;
import com.coders.DressStore.Entity.ProductsImages;
import com.coders.DressStore.Entity.ProductsView;

public interface ServiceDao {

	  List<Product> getProductsList();
	  Product getProduct(int id);
	  List<ProductsImages> getProductImagesList();
	  ProductsImages getProductImage(int id);
	  List<ProductsView> getAllProductsView();
}
