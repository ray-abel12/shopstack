package com.shopstack.sevice.product;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopstack.dao.product.ProductDao;
import com.shopstack.entities.product.Product;

public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public void addProduct(Product theProduct) {
		productDao.addProduct(theProduct);
		
	}

}
