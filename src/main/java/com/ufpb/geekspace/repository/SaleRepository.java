package com.ufpb.geekspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

	List<Sale> findByClientId(long clientId);

}
