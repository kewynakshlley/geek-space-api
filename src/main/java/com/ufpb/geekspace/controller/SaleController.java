package com.ufpb.geekspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.exception.StockException;
import com.ufpb.geekspace.model.Sale;
import com.ufpb.geekspace.service.SaleService;

@RestController
@RequestMapping(value = "sales")
public class SaleController {

	@Autowired
	private SaleService saleService;

	@GetMapping
	public List<Sale> retrieveAllSales() {
		return saleService.retrieveAllSales();
	}

	@GetMapping(value = "/{saleId}")
	public Sale retrieveOneSale(@PathVariable long saleId) throws DataNotFoundException {
		return saleService.retrieveOneSale(saleId);
	}

	@PostMapping(value = "/new/{shoppingCartId}")
	public ResponseEntity<?> newSale(@RequestBody Sale sale, @PathVariable long shoppingCartId) throws StockException {
		return saleService.newSale(sale, shoppingCartId);
	}

}
