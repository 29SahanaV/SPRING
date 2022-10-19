package com.springshoppy.repository;

import java.util.List;

import com.springshoppy.model.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product,Integer>{

	//productName
	product findByProductName(String productName);
	
	//productPrice
	//findByProductPrice
	@Query(value="select * from product where product_price < ?1",nativeQuery=true)
	List<product> findByProductPrice(int productPrice);
}