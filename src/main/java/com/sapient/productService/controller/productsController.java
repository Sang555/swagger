package com.sapient.productService.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;


import com.sapient.productService.model.*;
import com.sapient.productService.services.ProductServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;
@RestController
@RequestMapping("/api/v1/products")
public class productsController {

	@Autowired
	private ProductServices ps;
	
	@GetMapping(value="/", produces= {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
    @ApiOperation(value = "Fetch all employees", notes = "API to fetch all the employees")
	public List<Product> listAll()
	{
		List<Product> products= ps.listAll();


		return products;
		
	}
	
	@GetMapping(value="/{id}", produces= {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	public Product findById(@ApiParam(value="${ProductsController.FetchByID}")@PathVariable("id") int id)
	{
		return ps.findById(id);
	}
	
	@PostMapping(value="/", consumes= {APPLICATION_JSON_VALUE ,APPLICATION_XML_VALUE})
	public void saveProduct(@Valid @RequestBody Product product)
	{
		 ps.register(product);
	}
	
	@PutMapping(value="/{id}", consumes= {APPLICATION_JSON_VALUE ,APPLICATION_XML_VALUE})
	public void updateProduct(@PathVariable("id") int id, Product product)
	{
		ps.update(id,product);
	}

	@DeleteMapping(value="/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		ps.deleteprod(id);		
	}

}
