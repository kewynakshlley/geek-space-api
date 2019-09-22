package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.model.ShirtProduct;
import com.ufpb.geekspace.repository.ShirtProductRepository;
import com.ufpb.geekspace.util.ProductUtil;

@Service
public class ShirtProductService {

	@Autowired
	ShirtProductRepository camisaRepository;

	public List<ShirtProduct> retrievAllShirts() {
		return camisaRepository.findAll();
	}

	public ShirtProduct retrieveOneShirtProduct(long shirtId) {
		return camisaRepository.getOne(shirtId);
	}

	public ResponseEntity<?> createShirtProduct(ShirtProduct shirt) {
		ShirtProduct createdShirt = camisaRepository.save(shirt);
		return new ResponseEntity<ShirtProduct>(createdShirt, HttpStatus.OK);
	}

	public ResponseEntity<?> editShirtProduct(ShirtProduct shirt) {
		ShirtProduct createdShirt = camisaRepository.save(shirt);
		return new ResponseEntity<ShirtProduct>(createdShirt, HttpStatus.OK);
	}

	public void deleteShirtCamisa(long shirtId) throws DataNotFoundException {
		ShirtProduct sp = camisaRepository.getOne(shirtId);
		if(sp == null)
			throw new DataNotFoundException(ProductUtil.PRODUCT_NOT_FOUND);
		camisaRepository.delete(sp);
	}
}
