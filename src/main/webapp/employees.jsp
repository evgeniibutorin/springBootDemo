<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Spring Boot MVC and Hibernate CRUD Example</title>
<body>
<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
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
                <th>Action</th>
                <th>List of tags</th>
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
                       <a
                                href="<%=request.getContextPath()%>/update/employee/${t.id}">Update</a>
                        &nbsp; <a
                                href="<%=request.getContextPath()%>/delete/employee/${t.id}"
                                onclick="return confirm('Do you really want to delete?')">Delete</a>
                        <a
                                href="<%=request.getContextPath()%>/teg/${t.id}">Work with a tag</a>
                        <a
                                href="<%=request.getContextPath()%>/add/address/${t.id}">Add Address</a>
                    </td>
                    <td><c:forEach var="r" items="${t.tags}">${r.tag}</c:forEach></td>
                </tr>
            </c:forEach>
            </tbody>
            <br /><a href="<%=request.getContextPath()%>/similar/remover/">Remove similar employee</a><br /> <br />
            <br /> <br />
            <form method="GET" name="get_employee_by_name"
                  action="<%=request.getContextPath()%>/get/employee">
                Name: <input name="name" value="${name}" type="text" /> <br /> <br />
                <input value="Get Employee" type="submit" />
            </form>
        </table>
    </c:when>
    <c:otherwise>
        No User found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>