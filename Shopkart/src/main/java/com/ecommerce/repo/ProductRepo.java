package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{
	
	Product findById(long productId);

}
