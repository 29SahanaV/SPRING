package com.springshoppy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springshoppy.model.product;
import com.springshoppy.repository.productRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class productService {
	
	//repository to communicate and configure the DB
	@Autowired
	private productRepository repo;
	
	//getting produtcts and returning to controller
	public List<product> getAllProducts(){		
		List<product> productList=new ArrayList<>();
		repo.findAll().forEach(productList::add);
		return productList;
	}
	
	//adding product to DB
	public String addProduct(product p1) {
		repo.save(p1);
		return "successfully added!....";
	}
	
	//getting specified product if id is available--id is primary key
	public Optional<product> getProduct(int id) {
		return repo.findById(id);
	}
	
	//delete product byusing id
	public String deleteProduct(int id) {
		
		repo.deleteById(id);
		return "Deleted Successfully";
	}

	//adding multiple product at a time
	public String addallProducts(List<product> pl)
	{
		repo.saveAll(pl);
		return "successfully added";
	}

	//retriving by product name
	public product getProductByName(String productName) {
		return repo.findByProductName(productName);
	}

	//retriving by product price less than ....
	public List<product> getProductsByPrice(int productPrice){
		return repo.findByProductPrice(productPrice);
	}

}