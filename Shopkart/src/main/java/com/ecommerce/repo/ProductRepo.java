package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Admin;
import com.ecommerce.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	Product findById(long productId);

	@Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%" + " OR p.brand LIKE %?1%")

	public List<Product> search(String keyword);

}
