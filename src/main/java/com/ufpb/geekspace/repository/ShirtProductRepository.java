package com.ufpb.geekspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.ShirtProduct;
@Repository
public interface ShirtProductRepository extends JpaRepository<ShirtProduct, Long>{
	
	@Query(value="SELECT * FROM produto_camisa pg JOIN shopping_cart sc ON pg.id = sc.product_id "
			+ "JOIN client c ON sc.client_id = :client_id", nativeQuery = true)
	List<ShirtProduct> findShoppingCart(long client_id);

}
