package com.coder.computerStore.ComputerStore.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coder.computerStore.ComputerStore.Entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired 
    private EntityManager em;

	@Override
	public List<Product> listProducts() {
 		//return em.createNativeQuery("SELECT * FROM Products p", Product.class).getResultList();
		Session session = em.unwrap(Session.class);
		return session.createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public Product getProduct(Integer code) {
		Session session = em.unwrap(Session.class);
		return session.find(Product.class, code);
	}

	@Override
	public void updateProduct(Product product) {
		Session session = em.unwrap(Session.class);
		session.update(product);;
	}

	@Override
	public void deleteProduct(Product product) {
		Session session = em.unwrap(Session.class);
		session.delete(product);
	}

	@Override
	public void addProduct(Product product) {
		Session session = em.unwrap(Session.class);
		session.persist(product);		   
	}

}
