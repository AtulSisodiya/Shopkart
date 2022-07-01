package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
	
	@Query("SELECT n FROM Admin n WHERE n.username=:username AND n.password=:password")
	Admin validate(@Param ("username") String username, @Param ("password") String password);

}
