package com.cg.service;

import java.util.List;

import com.cg.entity.Product;

public interface IProductService {
	public List<Product> findAllProducts();
	public List<Product> findByProdName(String name);
	public void deleteProductById(int id);
	public Product newProduct(Product product);
	public Product updateProduct(int id,Product product);
}
