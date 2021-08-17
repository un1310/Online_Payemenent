package com.moneytap.CustomerWallet.repository;

import com.moneytap.CustomerWallet.model.JwtResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTRepository extends CrudRepository<JwtResponse,String> {
}
