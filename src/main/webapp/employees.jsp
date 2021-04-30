<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Spring Boot MVC and JDBC CRUD Example</title>
<body>
<h2>Spring Boot MVC and JDBC CRUD Example</h2>
<a href="<%=request.getContextPath()%>/addEmployee">Add</a>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${employees != null}">
        <h3>List of Employees</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Position</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="t" items="${employees}">
                <tr>
                    <td>${t.id}</td>
                    <td>${t.name}</td>
                    <td>${t.position}</td>
                    <td><a
                            href="<%=request.getContextPath()%>/employee/${t.id}">Details</a>
                        &nbsp;<a
                                href="<%=request.getContextPath()%>/update/employee/${t.id}">Update</a>
                        &nbsp; <a
                                href="<%=request.getContextPath()%>/delete/employee/${t.id}"
                                onclick="return confirm('Do you really want to delete?')">Delete</a></td>
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