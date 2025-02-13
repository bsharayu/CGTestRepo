package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Product;
import com.cg.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	ProductRepository productRepository;
	
	List<Product> productList=new ArrayList<>();
	
	@Override
	public List<Product> findAllProducts() {
	
//		productList.add(new Product(1,"Laptop",80000d));
//	    productList.add(new Product(2, "Smartphone", 50000d));
//	    productList.add(new Product(3, "Tablet", 30000d));
//	    productList.add(new Product(4, "Smartwatch", 15000d));
		return productRepository.findAll();
	}
	
	
	public Optional<Product> findByProductId(int id) {
		return productRepository.findById(id);
		
	}
	
	@Override
	public List<Product> findByProdName(String name) {
		return productRepository.findByPname(name);
		
	}

	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}


	@Override
	public Product newProduct(Product product) {
		return productRepository.save(product);
	}


	@Override
	public Product updateProduct(int id,Product product) {
		Optional<Product> p=productRepository.findById(id);
		p.get().setPname(product.getPname());
		p.get().setPrice(product.getPrice());
		productRepository.save(p.get());
		return p.get();
		
	}
	
	
}
