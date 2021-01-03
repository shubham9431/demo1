package com.sparkleweb.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({
	
	@NamedQuery(name="totalProducts", query = "from Products"),
	@NamedQuery(name = "totalProductsByCatID" , query = "from Products where category.catId=:id")
})
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proId;
	private String proNumber;
	private String proName;
	private String proDiscription;
	private int proPrice;
	private int proQuantity;
	private String proPic;
	@ManyToOne
	private Category category;
	
	
//	setter and Getter
	public int getProId() {
		return proId;
	}
//	public void setProId(int proId) {
//		this.proId = proId;
//	}
	public String getProNumber() {
		return proNumber;
	}
	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDiscription() {
		return proDiscription;
	}
	public void setProDiscription(String proDiscription) {
		this.proDiscription = proDiscription;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProQuantity() {
		return proQuantity;
	}
	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProPic() {
		return proPic;
	}
	public void setProPic(String proPic) {
		this.proPic = proPic;
	}
	
	
	
}
