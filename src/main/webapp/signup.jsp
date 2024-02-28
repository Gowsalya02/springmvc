<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="save" modelAttribute="employee">
Name:<form:input path="employeName"/><br><br>
Contact:<form:input path="employeeContact"/><br><br>
Mail:<form:input path="employeeMail"/><br><br>
Password:<form:input path="employeePassword"/><br><br>
City:<form:input path="employeeCity"/><br><br>
Salary:<form:input path="employeeSalary"/><br><br>
<input type="submit">
</form:form>
</body>
</html>
