package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Seller;
@Repository
public interface SellerRepo extends JpaRepository<Seller,Long>{

	@Query("SELECT c FROM Seller c WHERE c.username=:username AND c.password=:password")
	Seller validate(@Param ("username") String username, @Param ("password") String password);
}
