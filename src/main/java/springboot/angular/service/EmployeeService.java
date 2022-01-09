package springboot.angular.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import springboot.angular.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee findEmployeeById(Long id);

    public Employee updateEmployee(Long id, Employee employee);
}
