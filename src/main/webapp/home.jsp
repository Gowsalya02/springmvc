<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table,th,td{
border:3px solid black;
border-collapse:collapse;
padding:8px;
text-align:center;
}
table{
width:100%;}
</style>
</head>
<body>
<h1>Welcome</h1>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Contact</th>
    <th>Mail</th>
    <th>City</th>
    <th>Salary</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:forEach var="emp" items="${emps}" >
   <tr>
    <td>${emp.employeeaId}</td>
    <td>${emp.employeName}</td>
    <td>${emp.employeeContact}</td>
    <td>${emp.employeeMail}</td>
    <td>${emp.employeeCity}</td>
    <td>${emp.employeeSalary}</td>
    <td><a href="edit?employeeaId=${emp.employeeaId}">edit</a></td>
    <td><a href="delete?employeeaId=${emp.employeeaId}">delete</a></td>
  </tr>
  </c:forEach>
 
</table>


</body>
</html>