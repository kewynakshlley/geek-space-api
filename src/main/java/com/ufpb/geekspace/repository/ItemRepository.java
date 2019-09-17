package com.ufpb.geekspace.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	Set<Item> findByShoppingCartId(long shoppingCartId);

}
