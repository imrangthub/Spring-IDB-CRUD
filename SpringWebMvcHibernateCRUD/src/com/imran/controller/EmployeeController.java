package com.imran.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.imran.service.EmployeeService;
import com.imran.bean.EmployeeBean;
import com.imran.model.Employee;



@Controller
public class EmployeeController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		return new ModelAndView("addEmployee");
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result, ModelMap model) {
		
		model.addAttribute("message", "Record Saved Sucessfully");
		
		Employee empModelObj = prepareModel(employeeBean);
		employeeService.addEmployee(empModelObj);
		
		
		
		System.out.println(empModelObj.getEmpName()+" "+empModelObj.getEmpAge()+" "+empModelObj.getEmpAddress()+" "+empModelObj.getSalary());
		return new ModelAndView("redirect:/employees.html", model);
	}
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}
	

	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployees(@PathVariable("id") String id) {
		
		EmployeeBean employeeBean = new EmployeeBean();
		Integer empId = Integer.parseInt(id);
		employeeBean.setId(empId);
		
	    Map<String, Object> model = new HashMap<String, Object>();
	    model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getId())));
		
        System.out.println("Edit Id: "+ employeeBean.getId());
		return new ModelAndView("addEmployee", model);
	}

	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployees(@PathVariable("id") String id) {
		
		EmployeeBean employeeBean = new EmployeeBean();
		Integer empId = Integer.parseInt(id);
		employeeBean.setId(empId);
		employeeService.deleteEmployee(prepareModel(employeeBean));
		
        System.out.println("Delete Id: "+ empId);
		return new ModelAndView("redirect:/employees");
	}
	
	
	
	
	private Employee prepareModel(EmployeeBean employeeBean){
		Employee employee = new Employee();
		employee.setEmpAddress(employeeBean.getAddress());
		employee.setEmpAge(employeeBean.getAge());
		employee.setEmpName(employeeBean.getName());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}
	
	
	private List<EmployeeBean> prepareListofBean(List<Employee> employees){
		List<EmployeeBean> beans = null;
		if(employees != null && !employees.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(Employee employee : employees){
				bean = new EmployeeBean();
				bean.setName(employee.getEmpName());
				bean.setId(employee.getEmpId());
				bean.setAddress(employee.getEmpAddress());
				bean.setSalary(employee.getSalary());
				bean.setAge(employee.getEmpAge());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	private EmployeeBean prepareEmployeeBean(Employee employee){

		EmployeeBean bean = new EmployeeBean();
		bean.setAddress(employee.getEmpAddress());
		bean.setAge(employee.getEmpAge());
		bean.setName(employee.getEmpName());
		bean.setSalary(employee.getSalary());
		bean.setId(employee.getEmpId());
		return bean;
	}
	
	
	
	

}
