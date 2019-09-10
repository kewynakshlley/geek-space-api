package com.ufpb.geekspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.ProdutoGenerico;;
@Repository
public interface ProductRepository extends JpaRepository<ProdutoGenerico, Long>{
	
	/**@Query(value="SELECT * FROM ")
	List<ProdutoGenerico> findShoppingCart(long client_id);*/
}
