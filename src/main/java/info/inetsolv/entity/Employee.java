package info.inetsolv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="emp_tbl")
public class Employee {

	@Id
	@Column
	@SequenceGenerator(name="emp_eno_seq",sequenceName="emp_eno_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="emp_eno_seq")
	private Integer eno;
	private String name;
	private Double salary;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Employee(Integer eno, String name, Double salary) {
		super();
		this.eno = eno;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
