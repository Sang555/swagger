package com.sapient.productService.DAO;

import java.util.List;

import com.sapient.productService.model.Product;



public interface ProductDAO {
	public List<Product> listAll();
	public Product getById(int id);
	public void register(Product product);
	public void deleteProd(int id);
	public void update(int id, Product product);
}
