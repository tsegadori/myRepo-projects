package com.coder.computerStore.ComputerStore.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coder.computerStore.ComputerStore.Entity.Manufacturer;

@Repository
@Transactional
public class ManufacturerDaoImpl implements ManufacturerDao {

	@Autowired
	EntityManager em;
	
	
	@Override
	public List<Manufacturer> listManufacturers() {
		Session session = em.unwrap(Session.class);
		return session.createQuery("FROM Manufacturer m", Manufacturer.class).getResultList();
	}

	@Override
	public Manufacturer getManufacturer(Integer code) {
		Session session = em.unwrap(Session.class);
		return session.find(Manufacturer.class, code);
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		Session session = em.unwrap(Session.class);
		session.update(manufacturer);
	}

	@Override
	public void deleteManufacturer(Manufacturer manufacturer) {
		Session session = em.unwrap(Session.class);
		session.delete(manufacturer);
	}

	@Override
	public void addManufacturer(Manufacturer manufacturer) {
		Session session = em.unwrap(Session.class);
		session.persist(manufacturer);
	}

}
