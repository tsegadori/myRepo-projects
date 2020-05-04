package com.coders.DressStore.Dao;

import java.util.List;

import com.coders.DressStore.Entity.ProductsImages;

public interface ProductsImageDao {

	List<ProductsImages> getProductImagesList();
	ProductsImages getProductImage(int id);
}
