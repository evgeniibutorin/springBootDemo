<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>
<h2>Spring Boot MVC and JDBC CRUD Example</h2>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Add User</h3>
<form method="POST" name="add_employee"
      action="<%=request.getContextPath()%>/add/employee">
    Name: <input name="name" value="${name}" type="text" /> <br /> <br />
    Position: <input name="position" value="${position}" type="text" />
    <br /> <br />
    <input value="Add Employee" type="submit" />
</form>
</body>
</html>