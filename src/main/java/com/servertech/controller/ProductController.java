package com.servertech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servertech.model.Product;
import com.servertech.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//createProduct
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok().body(productService.createProduct(product));
	}
	
	//getAllProducts
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProduct(){
		return ResponseEntity.ok().body(productService.showAllProducts());
	}
	
	//getProductById
	@GetMapping("getById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id){
		return ResponseEntity.ok().body(productService.showProductById(id));
	}
	//updateProductById
	@PostMapping("updateById/{id}")
	public ResponseEntity<Product> updateProductById(@RequestBody Product product, @PathVariable long id){
		return ResponseEntity.ok().body(productService.updateProductById(product, id));
	}
	
	//deleteProduct
	@DeleteMapping("deleteById/{id}")
	public Map<String, Boolean> deleteProductById(@PathVariable long id){
		productService.deleteProductById(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
