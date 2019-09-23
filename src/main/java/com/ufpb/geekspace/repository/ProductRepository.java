package com.ufpb.geekspace.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value="SELECT * FROM produto pg JOIN shopping_cart sc ON pg.id = sc.product_id "
			+ "JOIN client c ON sc.client_id = :client_id", nativeQuery = true)
	List<Product> findShoppingCart(long client_id);

	List<Product> findByCategory(String category);

}
