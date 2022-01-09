package springboot.angular.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import springboot.angular.entity.Employee;

import springboot.angular.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
		
		public List<Employee> getAllEmployees(){
			return employeeRepository.findAll();
		}

		@Override
		public Employee saveEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}

		@Override
		public Employee findEmployeeById(Long id) {
			Optional<Employee> employee= 
					  employeeRepository.findById(id);
			    return employee.get();
		}

		@Override
		public Employee updateEmployee(Long id, Employee employee) {
			Employee empDB= employeeRepository.findById(id).get();
			
		if(Objects.nonNull(employee.getFirstName()) && 
		!"".equalsIgnoreCase(employee.getFirstName())) {
			empDB.setFirstName(employee.getFirstName());
		}
			
			if(Objects.nonNull(employee.getLastName()) && 
			!"".equalsIgnoreCase(employee.getLastName())) {
				empDB.setLastName(employee.getLastName());
			}
			
			if(Objects.nonNull(employee.getEmailId()) && 
			!"".equalsIgnoreCase(employee.getEmailId())) {
				empDB.setEmailId(employee.getEmailId());
						
		}
		return employeeRepository.save(empDB);
		}
	
	
}
