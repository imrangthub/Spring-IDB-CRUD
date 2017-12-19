package com.imran.dao;

import java.util.List;

import com.imran.model.Product;

public interface ProductDao {
	
    public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public List<Product> listProduct();
	
	public Product getProductById(Integer productId);
	
	public void removeProduct(Integer productId);

}
