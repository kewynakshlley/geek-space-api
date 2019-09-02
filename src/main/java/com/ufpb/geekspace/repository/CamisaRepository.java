package com.ufpb.geekspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.ProdutoCamisa;
@Repository
public interface CamisaRepository extends JpaRepository<ProdutoCamisa, Long>{

}
