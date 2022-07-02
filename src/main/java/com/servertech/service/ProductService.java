package com.servertech.service;

import java.util.List;

import com.servertech.model.Product;

public interface ProductService {

	Product createProduct(Product product);

	List<Product> showAllProducts();

	Product showProductById(long id);

	Product updateProductById(Product product, long id);

	void deleteProductById(long id);

}
