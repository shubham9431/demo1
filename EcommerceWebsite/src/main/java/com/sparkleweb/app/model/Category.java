package com.sparkleweb.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({
	
	@NamedQuery(name="dropdownCategory", query = "from Category")	
})
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	private String catName;
	private String catDescription;
	@OneToMany(mappedBy = "category")
	private List<Products> products;
	
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDescription() {
		return catDescription;
	}
	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public int getCatId() {
		return catId;
	}
}
