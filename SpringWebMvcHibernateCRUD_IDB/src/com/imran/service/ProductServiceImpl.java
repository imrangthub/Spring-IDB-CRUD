package com.imran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.dao.ProductDao;
import com.imran.model.Product;


@Service
public  class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
	
    public void addProduct(Product product){
    	productDao.addProduct(product);
    }
	
	public void updateProduct(Product product){
		productDao.updateProduct(product);
	}
	
	public List<Product> listProduct(){
		return productDao.listProduct();
	}
	
	public Product getProductById(Integer productId){
		return productDao.getProductById(productId);
	}
	
	public void removeProduct(Integer productId){
		productDao.removeProduct(productId);
	}
	

}
