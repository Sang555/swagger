package com.sapient.productService.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sapient.productService.DAO.ProductDAO;
import com.sapient.productService.model.Product;

@Service(value = "productsService")
public class productServiceImp implements ProductServices {
	
	@Autowired( required = true)
	@Qualifier(value="hibernateDAOImp")
	private ProductDAO productDAO;
	
	public productServiceImp(@Qualifier(value = "hibernateDAOImp")ProductDAO productDAO)
	{
		this.productDAO=productDAO;
	}
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		List<Product> prodList= productDAO.listAll();
		System.out.println(prodList.size());
		for(Product p:prodList)
		{
			System.out.println(p);
		}
		return prodList;
	}
	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productDAO.getById(id);
	}
	@Override
	public void register(Product product) {
		productDAO.register(product);
		
	}
	@Override
	public void deleteprod(int id) {
		// TODO Auto-generated method stub
		productDAO.deleteProd(id);
		
	}
	@Override
	public void update(int id, Product product) {
		// TODO Auto-generated method stub
		productDAO.update(id,product);
		
	}

}
