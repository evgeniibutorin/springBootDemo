<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>
<h2>Spring Boot MVC and JDBC CRUD Example</h2>
Id : ${employee.id}
<br /> Name : ${employee.name}
<br /> Position : ${employee.position}
<br /><a href="<%=request.getContextPath()%>/employees">Back to list</a>
</body>
</html>