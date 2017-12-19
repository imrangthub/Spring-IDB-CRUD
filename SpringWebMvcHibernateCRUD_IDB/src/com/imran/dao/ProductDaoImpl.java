package com.imran.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.tree.FromClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imran.model.Product;


@Repository
public class ProductDaoImpl implements ProductDao{
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
    public void addProduct(Product product){
    	sessionFactory.getCurrentSession().save(product);
    }
	
	@Transactional
	public void updateProduct(Product product){
		sessionFactory.getCurrentSession().update(product);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> listProduct() {
		return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public Product getProductById(Integer productId){
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@Transactional
	public void removeProduct(Integer productId){
		Product product = (Product)sessionFactory.getCurrentSession().load(Product.class, productId);
		if(product != null){
			sessionFactory.getCurrentSession().delete(product);
		}
	}
	

}
