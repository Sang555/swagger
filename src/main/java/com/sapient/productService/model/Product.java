package com.sapient.productService.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "Product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable{
	

	@Id
    @XmlElement(name = "ID")
    @Column(name="prod_id") 
	private int id;
    

    @XmlElement(name = "NAME")
    @Column(name="prod_name")
	private String name;
    
    @NotNull
    @Range(min = 10, max = 1000, message = "Price should be between 10 and 1000")
    @XmlElement
    @Column(name="prod_price")
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
