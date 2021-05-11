package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List<Product> listAll() {
		return productDao.findAll();
	}
	
	public void save(Product product) {
		productDao.save(product);
	}
	
	public Product get(Long id) {
		return productDao.findById(id).get();
	}
	
	public void delete(Long id) {
		productDao.deleteById(id);
	}
	
}
