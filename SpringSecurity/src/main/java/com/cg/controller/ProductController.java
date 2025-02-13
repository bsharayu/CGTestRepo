package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;
import com.cg.exception.ResourceNotFoundException;
import com.cg.service.ProductService;

@RestController
@RequestMapping("/papi")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/hello")
	public String greet() {
		return "Hello SpringRest! This is not a secured mapping";
	}

	@GetMapping(path = "/products/all")
	// @GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.findAllProducts();

	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) throws ResourceNotFoundException {
		return productService.findByProductId(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

	}

	@GetMapping("/products/{name}")
	public List<Product> getProductByProductName(@PathVariable String name) {
		return productService.findByProdName(name);

	}

//	@GetMapping("/product/name")
//	public List<Product> getProductByProductName1(@RequestParam String name) {
//		return productService.findByProdName(name);
//	}

	@DeleteMapping("/products/delete/{id}")
	public void deleteProdById(@PathVariable int id) {
		productService.deleteProductById(id);
	}

	@PostMapping("/products/add")
	public Product createProduct(@RequestBody Product product) {
		Product pr = productService.newProduct(product);
		return pr;
	}

	@PutMapping("/products/update/{id}")
	public Product updateProd(@PathVariable int id, @RequestBody Product product) {
		Product pr = productService.updateProduct(id, product);
		return pr;
	}

}
