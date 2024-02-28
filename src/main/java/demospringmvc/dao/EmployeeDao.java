package demospringmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demospringmvc.dto.Employee;

@Component
public class EmployeeDao 
{
	@Autowired
	EntityManager em;
	
	public Employee saveEmployee(Employee employee)
	{
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		return employee;
	}
	public Employee findById(int employeeId)
	{
		return em.find(Employee.class, employeeId);
	}

	public Employee deleteEmployee(int employeeId)
	{
		Employee emp=findById(employeeId);
		if(emp!=null)
		{
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();
			return emp;
		}
		return null;
	}
	public Employee updateEmployee(Employee emp,int employeeId)
	{
		Employee exEmp=findById(employeeId);
		if(exEmp!=null)
		{
			emp.setEmployeeaId(employeeId);
			em.getTransaction().begin();
			em.merge(emp);
			em.getTransaction().commit();
			return emp;
		}
		return null;
	}
	
	public List<Employee> getAllEmployee()
	{
		Query query=em.createQuery("select e from Employee e");
		
		List<Employee> empList=query.getResultList();
		return empList;
	}
	
	public Employee findByMail(String employeeMail)
	{
		Query query=em.createQuery("select e from Employee e where e.employeeMail=?1");
		query.setParameter(1, employeeMail);
		Employee employee=(Employee)query.getSingleResult();
		
		return employee;
	}
}
