package com.ufpb.geekspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpb.geekspace.model.ProdutoCamisa;
import com.ufpb.geekspace.service.ProductCamisaService;

@RestController
@RequestMapping(value = "ProdutoCamisa")
public class ProdutoCamisaController {

	@Autowired
	ProductCamisaService camisaService;

	@GetMapping
	public List<ProdutoCamisa> retrievAllCamisaProduct() {
		return camisaService.retrievAllCamisaProduct();
	}

	@GetMapping(value = "/{camisaId}")
	public ProdutoCamisa retrieveOneCamisaProduct(@PathVariable long camisaId) {
		return camisaService.retrievOneProductCamisa(camisaId);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<?> createCamisaProduct(@RequestBody ProdutoCamisa camisa) {
		return camisaService.createCamisaProduct(camisa);
	}

	@PutMapping
	public void editCamisaProduct(@RequestBody ProdutoCamisa camisa) {
		camisaService.editCamisaProduct(camisa);
	}

	@DeleteMapping(value = "/{camisaId}")
	public void deleteCaisaProduct(@PathVariable long camisaId) {
		camisaService.deletProductCamisa(camisaId);

	}

}
