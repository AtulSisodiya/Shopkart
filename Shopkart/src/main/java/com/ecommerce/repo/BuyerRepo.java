package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Buyer;
@Repository
public interface BuyerRepo extends JpaRepository<Buyer,Long>{

	@Query("SELECT b FROM Buyer b WHERE b.username=:username AND b.password=:password")
	Buyer validate(@Param ("username") String username, @Param ("password") String password);


}
