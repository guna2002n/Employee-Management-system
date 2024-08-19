package Com.Employee.Service;

import java.util.List;

import Com.Employee.Bean.Employee;

public interface EmployeeService {
	public void Create(Employee emp,long id);
	public Employee getEmployee(long id);
	public List<Employee> getAllEmployee();
	public Employee update(Employee emp,long id);
	public void delete(long id);
}
