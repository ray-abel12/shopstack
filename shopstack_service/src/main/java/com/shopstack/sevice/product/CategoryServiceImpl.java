package com.shopstack.sevice.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopstack.dao.product.CategoryDao;
import com.shopstack.entities.product.Category;

public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void addCategory(Category theCategory) {
		categoryDao.addCategory(theCategory);
		
	}



}
