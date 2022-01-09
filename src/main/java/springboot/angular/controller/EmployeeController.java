package springboot.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.angular.entity.Employee;
import springboot.angular.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);	
	}
	
	@GetMapping("/get")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	 @GetMapping("/{id}")
	   public Employee findEmployeeById(@PathVariable("id")Long id)
	    { 
		 return employeeService.findEmployeeById(id);
	  }
	 @PutMapping("update/{id}")
	 public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
		 return employeeService.updateEmployee(id, employee);
	 }
}
