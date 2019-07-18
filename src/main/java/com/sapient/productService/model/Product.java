package com.sapient.productService.model;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable{
	private int id;
	private String name;
	private double price;
	
	public Product(int int1, String string, double double1) {
		// TODO Auto-generated constructor stub
		this.id=int1;
		this.name=string;
		this.price=double1;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	public void Product()
	{

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
