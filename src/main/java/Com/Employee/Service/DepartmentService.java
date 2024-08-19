package Com.Employee.Service;

import java.util.List;

import Com.Employee.Bean.Department;


public interface DepartmentService {
				//Add Department
	public Department addDepartment(Department dept);
				//Get Department by id
	public Department getbyid(long id);
				
				//GET ALL DEPARTMENTS 
	public List<Department> getall();
	
				//Update Employee
	public Department Update(Department d);
	
				//Delete Department
	public String delete(long id );
	
}
