package com.shopstack.controller.product;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopstack.dao.product.CategoryDao;
import com.shopstack.dao.product.ProductDao;
import com.shopstack.entities.product.Category;

@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger logger=Logger.getLogger(ProductController.class);
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
	
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/categoryform")
	public String showCustomeRegisterForm(Model myModel) {
		
	   myModel.addAttribute("category", new Category());
	   
		return "customer-form";
	}
	
}
