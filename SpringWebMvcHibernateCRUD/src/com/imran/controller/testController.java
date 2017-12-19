package com.imran.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/test")
public class testController {
	@RequestMapping(value="/check")
	public String sayHello(ModelMap map){
		map.addAttribute("msg", "This is a message form Controller");
		return "check";
	}
}
    
