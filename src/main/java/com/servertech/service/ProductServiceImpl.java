package com.servertech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servertech.exception.ResourceNotFoundException;
import com.servertech.model.Product;
import com.servertech.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> showAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product showProductById(long id) {
		Optional<Product> productDB=productRepository.findById(id);
		if(productDB.isPresent()) {
			Product getProduct=productDB.get();
			return getProduct;
		}
		throw new ResourceNotFoundException("Product NOt there for id : " + id);
	}

	@Override
	public Product updateProductById(Product product,long id) {
		Product productDB=productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found for this id :" + id));
		productDB.setName(product.getName());
		productDB.setDescription(product.getDescription());
		productDB.setPrice(product.getPrice());
		productRepository.save(productDB);
		return productDB;
	}

	@Override
	public void deleteProductById(long id) {
		Product productDB=productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found for this id :" + id));
		productRepository.delete(productDB);
	}

}
