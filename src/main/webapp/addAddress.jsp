<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<title>Spring Boot MVC and Hibernate CRUD Example</title>
<body>
<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
Id : ${employee.id}
<br /> Name : ${employee.name}
<br /> Position : ${employee.position}
<br /><a href="<%=request.getContextPath()%>/employees">Back to list</a>

<h3>Add address</h3>
<form method="POST" name="add_address"
      action="<%=request.getContextPath()%>/update/address">
    <input hidden="hidden" name="id" value="${id}" type="text" /> Address: <input
        name="address" value="${address.address}" type="text" /> <br /> <br />
    <br /> <br />
    <input value="Add Address for ${employee.name}" type="submit" />
</form>
</body>
</html>