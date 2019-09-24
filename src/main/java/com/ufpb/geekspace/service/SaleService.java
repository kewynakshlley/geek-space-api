package com.ufpb.geekspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.exception.StockException;
import com.ufpb.geekspace.model.Item;
import com.ufpb.geekspace.model.Product;
import com.ufpb.geekspace.model.Sale;
import com.ufpb.geekspace.model.ShoppingCart;
import com.ufpb.geekspace.repository.ProductRepository;
import com.ufpb.geekspace.repository.SaleRepository;
import com.ufpb.geekspace.repository.ShoppingCartRepository;
import com.ufpb.geekspace.util.SaleUtil;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private ProductRepository productRepository;

	public List<Sale> retrieveAllSales() {
		return saleRepository.findAll();
	}

	public Sale retrieveOneSale(long saleId) throws DataNotFoundException {
		Sale s = saleRepository.getOne(saleId);
		if (s == null)
			throw new DataNotFoundException(SaleUtil.SALE_NOT_FOUND);
		return saleRepository.getOne(saleId);
	}

	public ResponseEntity<?> newSale(Sale sale, long shoppingCartId) throws StockException {
		ShoppingCart sc = shoppingCartRepository.getOne(shoppingCartId);
		sale.setShoppingCart(sc);
		sale.setClient(sc.getClient());
		Sale newSale = saleRepository.save(sale);
		for (Item i : sc.getItems()) {
			Optional<Product> paux = productRepository.findById(i.getProduct().getId());
			if(paux != null) {
				int pAuxQ = paux.get().getQuantity();
				int iQ = i.getQuantity();
				if ((pAuxQ - iQ) < 0)
					throw new StockException(SaleUtil.OUT_OF_STOCK);
				paux.get().setQuantity(pAuxQ - iQ);
				productRepository.save(paux.get());
			}

		}
		return new ResponseEntity<Sale>(newSale, HttpStatus.OK);
	}

	public List<Sale> getClientSales(long clientId) {
		return saleRepository.findByClientId(clientId);
	}

}
