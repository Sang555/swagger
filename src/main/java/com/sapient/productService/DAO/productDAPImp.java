package com.sapient.productService.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.productService.model.Product;

@Repository(value = "daoImp")
public class productDAPImp implements ProductDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Product> listAll() {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(dataSource);

		List<Product> prodList=jdbcTemplate.query("select * from product",
				(rs,rowNum) -> new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		System.out.println(prodList.size());
		for(Product p:prodList)
		{
			System.out.println(p);
		}
		return prodList;
	}

	@Override
	public Product getById(int id) {
		
			
			String query="select * from product where id="+id;
			//List<Employee> empList=jdbcTemplate.query(query,
			//		(rs,rowNum) -> new Employee(rs.getInt(1),rs.getString(2),rs.getInt(1),rs.getDouble(4)));
			//return empList.get(0);
			jdbcTemplate = new JdbcTemplate(dataSource);
			List<Product> prodList= jdbcTemplate.query(query,
					(rs,rowNum) -> new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			// TODO Auto-generated method stub
			Product product= prodList.get(0);
			return product;
			
		
	}

	@Override
	public void register(Product product) {
		String query = "insert into product values('" + product.getId() + "','" + product.getName() + "','" + product.getPrice() + "')";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(query);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProd(int id) {
		// TODO Auto-generated method stub
		String query="delete  from product where id= ? ";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(query,id);
		
	}

	@Override
	public void update(int id, Product product) {
		String query ="update product set price=? where id=?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(query,product.getPrice(),id);	
		// TODO Auto-generated method stub
		
	}

}
