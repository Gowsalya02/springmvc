package demospringmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demospringmvc.dao.EmployeeDao;
import demospringmvc.dto.Employee;

@Controller
public class AppController 
{
	@Autowired
	EmployeeDao dao;
	@RequestMapping("test")
	public void test(HttpServletResponse resp) throws IOException
	{
		PrintWriter pw=resp.getWriter();
		pw.print("Hello world");
	}
	
	@RequestMapping("/signup")
	public ModelAndView signUp()
	{
		ModelAndView view=new ModelAndView();
		view.addObject("employee", new Employee());
		view.setViewName("signup.jsp");
		return view;
	}
	
	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee)
	{
		dao.saveEmployee(employee);
		ModelAndView view=new ModelAndView();
		view.setViewName("login.jsp");
		return view;
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	 public ModelAndView loginEmp(@RequestParam String  mail,@RequestParam String password)
	 {
		
		Employee exEmp=dao.findByMail(mail);
		if(exEmp!=null)
		{
			if(exEmp.getEmployeePassword().equals(password))
			{
			  
		      ModelAndView view =new ModelAndView();
		      view.addObject("emps",dao.getAllEmployee());
		      view.setViewName("home.jsp");
		      return view;
			}
			return new ModelAndView("login.jsp");
			
		}
		return new ModelAndView("login.jsp");
	 }
	
	@RequestMapping("/delete")
	public ModelAndView deleteEmp(@RequestParam int employeeaId)
	{
		dao.deleteEmployee(employeeaId);
		ModelAndView view =new ModelAndView();
	    view.addObject("emps",dao.getAllEmployee());
	    view.setViewName("home.jsp");
	    return view;
	}
	@RequestMapping("/edit")
	public ModelAndView editEmp(@RequestParam int employeeaId)
	{
		ModelAndView view=new ModelAndView();
		view.addObject("employee", dao.findById(employeeaId));
		view.setViewName("edit.jsp");
		return view;
	}
	@RequestMapping("/update")
	public ModelAndView updateEmp(@ModelAttribute Employee emp)
	{
		dao.updateEmployee(emp, emp.getEmployeeaId());
		ModelAndView view =new ModelAndView();
	    view.addObject("emps",dao.getAllEmployee());
	    view.setViewName("home.jsp");
	    return view;
	}
	
	
}
