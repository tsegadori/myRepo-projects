package com.coders.DressStore.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product_images")
public class ProductsImages {

	@Id
	@Column(name="id")
	private int id;
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name="product_id")
	@JsonIgnore
	private Product product;
	@Column(name="name")
	private String name;
	@Column(name="created")
	private Date created;
	@Column(name="modified")
	private Date modified;
	
	public ProductsImages() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	
}
