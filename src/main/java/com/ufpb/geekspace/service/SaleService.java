package com.ufpb.geekspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.exception.StockException;
import com.ufpb.geekspace.model.GenericProduct;
import com.ufpb.geekspace.model.Item;
import com.ufpb.geekspace.model.Sale;
import com.ufpb.geekspace.model.ShirtProduct;
import com.ufpb.geekspace.model.ShoppingCart;
import com.ufpb.geekspace.repository.GenericProductRepository;
import com.ufpb.geekspace.repository.SaleRepository;
import com.ufpb.geekspace.repository.ShirtProductRepository;
import com.ufpb.geekspace.repository.ShoppingCartRepository;
import com.ufpb.geekspace.util.SaleUtil;

import java.util.List;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private ShirtProductRepository shirtProductRepository;
	@Autowired
	private GenericProductRepository genericProductRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	
	public List<Sale> retrieveAllSales() {
		return saleRepository.findAll();
	}
	
	public Sale retrieveOneSale(long saleId) throws DataNotFoundException {
		Sale s = saleRepository.getOne(saleId);
		if(s == null)
			throw new DataNotFoundException(SaleUtil.SALE_NOT_FOUND);
		return saleRepository.getOne(saleId);
	}
	
	public ResponseEntity<?> newSale(Sale sale, long shoppingCartId) throws StockException{
		ShoppingCart sc = shoppingCartRepository.getOne(shoppingCartId);
		sale.setShoppingCart(sc);
		sale.setClient(sc.getClient());
		Sale newSale = saleRepository.save(sale);
		for(Item i: sc.getItems()) {
			ShirtProduct paux = null;
			GenericProduct gaux = null;
			paux = shirtProductRepository.getOne(i.getProduct().getId());
			if(paux != null) {
				int pAuxQ = paux.getQuantity();
				int iQ = i.getQuantity();
				if((pAuxQ - iQ) < 0)
					throw new StockException(SaleUtil.OUT_OF_STOCK);
				paux.setQuantity(pAuxQ - iQ);
				shirtProductRepository.save(paux);
				continue;
			}
			
			gaux = genericProductRepository.getOne(i.getProduct().getId());
			if(gaux != null) {
				int gAuxQ = gaux.getQuantity();
				int iQ = i.getQuantity();
				if((gAuxQ - iQ) < 0)
					throw new StockException(SaleUtil.OUT_OF_STOCK);
				gaux.setQuantity(gAuxQ - iQ);
				genericProductRepository.save(gaux);
			}
			
		}
		return new ResponseEntity<Sale>(newSale, HttpStatus.OK);
	}
	
	
}
