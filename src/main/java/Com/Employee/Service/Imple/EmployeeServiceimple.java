package Com.Employee.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Employee.Bean.Department;
import Com.Employee.Bean.Employee;
import Com.Employee.Exception.EmployeeNotFound;
import Com.Employee.Repository.Department_Repository;
import Com.Employee.Repository.Employee_Repository;
import Com.Employee.Service.EmployeeService;

@Service
public class EmployeeServiceimple implements EmployeeService{
	
	private Employee_Repository emprepo;
	private Department_Repository deptrepo;
	@Autowired
	public EmployeeServiceimple(Employee_Repository emprepo,Department_Repository deptrepo) {
		super();
		this.emprepo = emprepo;
		this.deptrepo=deptrepo;
	}

	@Override
	public  void Create(Employee emp,long id) {
		System.out.println(emp.toString());
		Department de=deptrepo.findById(id).orElseThrow(()->new EmployeeNotFound("The department id is not found"));
		emp.setDept(de);
		Employee e=emprepo.save(emp);
		System.out.println("local employe"+e+"\nparameter"+emp);
	}

	@Override
	public Employee getEmployee(long id) {
		return emprepo.findById(id).orElseThrow(()->new EmployeeNotFound("the employee id does not exitst"+id));
	}

	@Override
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}

	@Override
	public Employee update(Employee emp,long id) {
		Employee e=emprepo.findById(emp.getId()).orElseThrow(()->new EmployeeNotFound("The Employee id doesnot exit: "+emp.getId()));
		e.setEmail(emp.getEmail());
		e.setFname(emp.getFname());
		e.setLname(emp.getLname());
		e.setDept(deptrepo.findById(id).orElseThrow(()->new EmployeeNotFound("Employee not found")));
		return emprepo.save(e);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		 emprepo.deleteById(id);
	}
	
	
	
}
