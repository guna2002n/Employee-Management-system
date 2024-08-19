package Com.Employee.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Com.Employee.Bean.Employee;
import Com.Employee.Service.EmployeeService;

@CrossOrigin("*")
@RequestMapping("/employee")
@Controller
public class Employee_Controller {
	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/add/{id}")
	@ResponseBody
	public Employee createrepo(@RequestBody Employee emp ,@PathVariable long id)
	{
		
		System.out.println(emp.toString());
		employeeservice.Create(emp,id);
		return emp;
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> get(@PathVariable("id") long id)
	{
		System.out.println("getmethod called");
		Employee e=employeeservice.getEmployee(id);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
				//Get all the employee recods:
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getall()
	{
		return new ResponseEntity<>(employeeservice.getAllEmployee(),HttpStatus.OK);
	}
	
				//Update Employee:
	@PutMapping("update/{id}")
	@ResponseBody
	public ResponseEntity<Employee> Update( @RequestBody Employee emp,@PathVariable long id)
	{
		System.out.println("put method called\n"+emp);
		return new ResponseEntity<>(employeeservice.update(emp,id),HttpStatus.OK);
	}
	
	
					//Delete Employee:
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") long id)
	{
		employeeservice.delete(id);
		return "the employee has been deleted";
	}
}
