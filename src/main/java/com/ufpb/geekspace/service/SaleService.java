package com.ufpb.geekspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.model.Sale;
import com.ufpb.geekspace.repository.SaleRepository;

import java.util.List;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	
	public List<Sale> retrieveAllSales() {
		return saleRepository.findAll();
	}
	
	public Sale retrieveOneSale(long saleId) {
		return saleRepository.getOne(saleId);
	}
	
	public ResponseEntity<?> newSale(Sale sale){
		Sale newSale = saleRepository.save(sale);
		return new ResponseEntity<Sale>(newSale, HttpStatus.OK);
	}
	
	
}
