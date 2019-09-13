package com.ufpb.geekspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufpb.geekspace.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
