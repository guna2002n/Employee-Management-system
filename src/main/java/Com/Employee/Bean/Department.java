package Com.Employee.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Department id")
	private long id;

	@Column(name = "Department Name")
	private String depat_name;

	@Column(name = "Department Description")
	private String desc;

	/*
	 * @Column(name="Employee id")
	 * 
	 * @OneToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "Emp") private Employee emp;
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepat_name() {
		return depat_name;
	}

	public void setDepat_name(String depat_name) {
		this.depat_name = depat_name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", depat_name=" + depat_name + ", desc=" + desc + "]";
	}

	public Department(long id, String depat_name, String desc) {
		super();
		this.id = id;
		this.depat_name = depat_name;
		this.desc = desc;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

}
