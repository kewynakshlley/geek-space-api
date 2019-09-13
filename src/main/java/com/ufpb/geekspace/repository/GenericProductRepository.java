package com.ufpb.geekspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.GenericProduct;
import com.ufpb.geekspace.model.ShoppingCart;
@Repository
public interface GenericProductRepository extends JpaRepository<GenericProduct, Long>{

	@Query(value="SELECT * FROM shopping_cart WHERE client_id = :client_id", nativeQuery = true)
	List<ShoppingCart> findShoppingCart(long client_id);
}
