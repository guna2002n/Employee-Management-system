package Com.Employee.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name = "Employee")
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Firstname")
	private String Fname;
	
	@Column(name = "LastName")
	private String Lname;
	
	@Column(name = "Email")
	private String email;
	
	
	//@Column(name="Department Id")
	@JoinColumn(name = "dept_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Department dept;


	@Override
	public String toString() {
		return "Employee [id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", dept=" + dept
				+ "]";
	}


	public Employee(Long id, String fname, String lname, String email, Department dept) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
		this.email = email;
		this.dept = dept;
	}


	public Employee() {
		
		super();
		// TODO Auto-generated constructor stub
		//System.out.println("Bean created");
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFname() {
		return Fname;
	}


	public void setFname(String fname) {
		Fname = fname;
	}


	public String getLname() {
		return Lname;
	}


	public void setLname(String lname) {
		Lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}	
}
