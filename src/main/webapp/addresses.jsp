<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Spring Boot MVC and Hibernate CRUD Example</title>
<body>
<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
<a href="<%=request.getContextPath()%>/employees">Show employees</a>

<c:choose>
    <c:when test="${addresses != null}">
        <h3>List of Addresses</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>Address id</th>
                <th>Address</th>
                <th>Employees</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="a" items="${addresses}">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.address}</td>
                    <td><c:forEach var="e" items="${e.employees}">${e.name}</c:forEach></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No User found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>