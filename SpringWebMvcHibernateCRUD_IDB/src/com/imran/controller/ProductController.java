package com.imran.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.imran.model.Product;
import com.imran.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public ModelAndView listProduct() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		List<Product> results = new ArrayList<Product>();
		results= productService.listProduct();
		model.put("products", results);
		return new ModelAndView("productIndex", model);
	}

	@RequestMapping("/create")
	public String create(){
		return "create";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addBook(ModelMap map,@ModelAttribute("priduct") Product product, BindingResult result){
		if(product.getId()==null){
			productService.addProduct(product);
			map.addAttribute("successMsg", "Successfully add Your Product");
		}else{
			productService.updateProduct(product);
		}
		
		return "redirect:/create";
	}
	
	
	@RequestMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id){
		productService.removeProduct(id);
		System.out.println(id);
		return "redirect:/product";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, Map<String, Object> map){
		Product product = productService.getProductById(id);
		map.put("product", product);
		System.out.println(product);
		return "create";
	}
	

}
