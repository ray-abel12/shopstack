package com.shopstack.dao.product;

import java.util.List;

import com.shopstack.entities.product.Product;

/**
 * @author RAY-ABEL
 *
 */
public interface ProductDao {

	public void addProduct(Product theProduct);
	
	public List<Product> getProduct();
}
