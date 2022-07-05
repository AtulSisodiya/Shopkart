package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Integer> {

}
