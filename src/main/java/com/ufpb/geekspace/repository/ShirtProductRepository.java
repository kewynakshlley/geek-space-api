package com.ufpb.geekspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.ShirtProduct;
@Repository
public interface ShirtProductRepository extends JpaRepository<ShirtProduct, Long>{
	
	@Query(value="SELECT sp.id, sp.description, sp.name, sp.price, sp.quantity, sp.especification, sp.color, sp.genre FROM shirt_product sp JOIN shopping_cart sc ON sp.id = sc.product_id WHERE sc.client_id = :client_id", nativeQuery = true)
	List<ShirtProduct> findShoppingCart(long client_id);

}
