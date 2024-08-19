package Com.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Employee.Bean.Department;

public interface Department_Repository  extends JpaRepository<Department, Long>{

}
