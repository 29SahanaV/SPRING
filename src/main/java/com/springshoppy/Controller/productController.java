package com.springshoppy.Controller;

import java.util.List;
import java.util.Optional;

import com.springshoppy.model.product;
import com.springshoppy.service.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {

	
	@Autowired
	private productService service;
	
	//getting all products from DB
	@RequestMapping(method=RequestMethod.GET, value="/products")
	public List<product> getAllProducts(){
		return service.getAllProducts();
	}
	//adding new product to DB
	@RequestMapping(method=RequestMethod.POST, value="/products")
	public String addProduct(@RequestBody product p1){
		return service.addProduct(p1);
	}
	
	//adding list of products to db
	@RequestMapping(method=RequestMethod.POST, value="/addall")
	public String addAll(@RequestBody List<product> productList)
	{
		return service.addallProducts(productList);
	}
	
	//getting products by name 
	@RequestMapping(method=RequestMethod.GET,value="/productname/{name}")
	public product getProductByName(@PathVariable String name)
	{
		return service.getProductByName(name);
	}
	
	//getting products by price
	@RequestMapping(method=RequestMethod.GET, value="/productprice/{amount}")
	public List<product> getProductsByPrice(@PathVariable int amount){
		return service.getProductsByPrice(amount);
	}

	//getting specific product from DB
	@RequestMapping(method=RequestMethod.GET, value="/product/{id}")
	public Optional<product> getProduct(@PathVariable int id) {
		return service.getProduct(id);
	}

	//delete product from DB
	@RequestMapping(method=RequestMethod.DELETE, value="/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		
		return service.deleteProduct(id);
		
	}
	
}
