/**
 * 
 */
package com.shopstack.entities.product;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RAY-ABEL
 *
 */
@Entity
@Table(name="ss_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_code")
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="purchase_date")
	private Date purchaseDate;
	
	@Column(name="price")
	private Double Price;
	
	@Column(name="decription")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="category_id")
	private Category category;
	
	public Product() {
		
	}

	public Product(String productName, Date purchaseDate, Double price, String description) {
		
		this.productName = productName;
		this.purchaseDate = purchaseDate;
		Price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
