package Com.Employee.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Employee.Bean.Department;
import Com.Employee.Exception.EmployeeNotFound;
import Com.Employee.Repository.Department_Repository;
import Com.Employee.Service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private Department_Repository department;

	@Override
	public Department addDepartment(Department dept) {
		
		return department.save(dept);
	}

	@Override
	public Department getbyid(long id) {
		return department.findById(id).orElseThrow(()->new EmployeeNotFound("Department not found"));
		 
	}

	@Override
	public List<Department> getall() {
		return department.findAll();
	}

	@Override
	public Department Update(Department d) {
		Department dep=this.getbyid(d.getId());
		dep.setDepat_name(d.getDepat_name());
		dep.setDesc(d.getDesc());
		department.save(dep);
		return dep;
	}

	@Override
	public String delete(long id) {
		// TODO Auto-generated method stub
		Department d=department.findById(id).orElseThrow(()-> new EmployeeNotFound("Employee is not found"));
		department.deleteById(d.getId());
		return "Department has been deleted successfully";
	}
	
}
