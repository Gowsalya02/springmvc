package demospringmvc.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeaId;
	private String  employeName;
	private long employeeContact;
	private String employeeMail;
	private String employeePassword;
	private String employeeCity;
	private double employeeSalary;
	
	public int getEmployeeaId() {
		return employeeaId;
	}
	public void setEmployeeaId(int employeeaId) {
		this.employeeaId = employeeaId;
	}
	public String getEmployeName() {
		return employeName;
	}
	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}
	public long getEmployeeContact() {
		return employeeContact;
	}
	public void setEmployeeContact(long employeeContact) {
		this.employeeContact = employeeContact;
	}
	public String getEmployeeMail() {
		return employeeMail;
	}
	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee [employeeaId=" + employeeaId + ", employeName=" + employeName + ", employeeContact="
				+ employeeContact + ", employeeMail=" + employeeMail + ", employeePassword=" + employeePassword
				+ ", employeeCity=" + employeeCity + ", employeeSalary=" + employeeSalary + "]";
	}
	
	

}
