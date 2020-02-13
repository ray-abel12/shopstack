package com.shopstack.dao.product;

import java.util.List;

import com.shopstack.entities.product.Category;

/**
 * @author RAY-ABEL
 *
 */

public interface CategoryDao {

	public void addCategory(Category theCategory);
	
	public List<Category> getCategory();
}
