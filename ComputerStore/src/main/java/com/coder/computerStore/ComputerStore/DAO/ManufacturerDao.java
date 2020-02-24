package com.coder.computerStore.ComputerStore.DAO;

import java.util.List;

import com.coder.computerStore.ComputerStore.Entity.Manufacturer;

public interface ManufacturerDao {

	List<Manufacturer> listManufacturers();
	Manufacturer getManufacturer(Integer code);
	void updateManufacturer(Manufacturer manufacturer);
	void deleteManufacturer(Manufacturer manufacturer);
	void addManufacturer(Manufacturer manufacturer);
}
