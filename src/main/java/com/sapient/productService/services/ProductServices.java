package com.sapient.productService.services;

import java.util.List;

import com.sapient.productService.model.Product;



public interface ProductServices {
	
	public List<Product> listAll();
	public Product findById(int id);
	public void register(Product product);
	public void deleteprod(int id);
	public void update(int id, Product product);
}
