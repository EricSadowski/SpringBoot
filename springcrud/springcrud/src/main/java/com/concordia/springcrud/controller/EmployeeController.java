package com.concordia.springcrud.controller;

import com.concordia.springcrud.entity.Employee;
import com.concordia.springcrud.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	public EmployeeController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}


	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId){

		employeeService.deleteById(theId);

		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel){

		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);

		// send over to our form
		return "employees/employee-form";
	}


	@GetMapping("/showFormForAdd")
	public String showFormForAdd (Model theModel){
		//create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	// load employee data

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}


	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		//get employee from db
		List<Employee> theEmployee = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployee);

		return "employees/list-employees";
	}
}









