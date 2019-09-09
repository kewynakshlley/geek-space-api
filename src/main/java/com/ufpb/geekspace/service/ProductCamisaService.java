package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.model.ProdutoCamisa;
import com.ufpb.geekspace.repository.CamisaRepository;

@Service
public class ProductCamisaService {

	@Autowired
	CamisaRepository camisaRepository;
	
	public List<ProdutoCamisa> retrievAllCamisaProduct(){
		return camisaRepository.findAll();
	}
	
	public ProdutoCamisa retrievOneProductCamisa(long camisaID) {
		return camisaRepository.getOne(camisaID);
	}
	
	public ResponseEntity<?> createCamisaProduct(ProdutoCamisa camisa){
		ProdutoCamisa createdCamisa = camisaRepository.save(camisa);
		return new ResponseEntity<ProdutoCamisa>(createdCamisa, HttpStatus.OK);
	}
	
	public ResponseEntity<?> editCamisaProduct(ProdutoCamisa camisa){
		ProdutoCamisa createdCamisa = camisaRepository.save(camisa);
		return new ResponseEntity<ProdutoCamisa>(createdCamisa, HttpStatus.OK);
	}
	
	public void deletProductCamisa(long CamisaID) {
		camisaRepository.deleteById(CamisaID);
	}
}
