package com.ufpb.geekspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.ProdutoGenerico;;
@Repository
public interface ProductRepository extends JpaRepository<ProdutoGenerico, Long>{

}
