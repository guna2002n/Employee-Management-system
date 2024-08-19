package Com.Employee.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Employee.Bean.Department;
import Com.Employee.Service.DepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Department")
public class Department_Controller {
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/create")
	public ResponseEntity<Department> add_depart(@RequestBody Department dep)
	{
		System.out.println(dep);
		return ResponseEntity.ok(service.addDepartment(dep));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Department> get(@PathVariable long id)
	{
		return ResponseEntity.ok(service.getbyid(id));
	}
	
	@GetMapping("departments")
	public ResponseEntity<List<Department>> getall()
	{
		System.out.println("called");
		return ResponseEntity.ok( service.getall());
	}
	
				//update
	@PutMapping("/update")
	public ResponseEntity<Department> update(@RequestBody Department dep)
	{
		return ResponseEntity.ok(service.Update(dep));
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id)
	{
		return  service.delete(id);
	}
}
