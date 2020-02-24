package com.coder.computerStore.ComputerStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coder.computerStore.ComputerStore.DAO.ManufacturerDao;
import com.coder.computerStore.ComputerStore.DAO.ProductDao;
import com.coder.computerStore.ComputerStore.Entity.Manufacturer;
import com.coder.computerStore.ComputerStore.Entity.Product;

@Service
@Transactional
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	ManufacturerDao mDao;
	@Autowired
	ProductDao pDao;
	
	@Override
	public List<Product> listProducts() {
		return pDao.listProducts();
	}

	@Override
	public Product getProduct(Integer code) {
		return pDao.getProduct(code);
	}

	@Override
	public void updateProduct(Product product) {
		pDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		pDao.deleteProduct(product);
	}

	@Override
	public void addProduct(Product product) {
		pDao.addProduct(product);
	}

	@Override
	public List<Manufacturer> listManufacturers() {
		return mDao.listManufacturers();
	}

	@Override
	public Manufacturer getManufacturer(Integer code) {
		return mDao.getManufacturer(code);
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		mDao.updateManufacturer(manufacturer);
	}

	@Override
	public void deleteManufacturer(Manufacturer manufacturer) {
		mDao.deleteManufacturer(manufacturer);
	}

	@Override
	public void addManufacturer(Manufacturer manufacturer) {
		mDao.addManufacturer(manufacturer);
	}

}
