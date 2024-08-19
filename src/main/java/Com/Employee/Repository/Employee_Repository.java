package Com.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Employee.Bean.Employee;

public interface Employee_Repository  extends JpaRepository<Employee, Long>{

}
