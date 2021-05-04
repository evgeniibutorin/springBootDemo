<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Spring Boot MVC and Hibernate CRUD Example</title>
<body>
<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
Id : ${employee.id}
<br/> Name : ${employee.name}
<br/> Position : ${employee.position}
<br/><a href="<%=request.getContextPath()%>/employees">Back to the list of employees</a>

<h3>Add Tag</h3>
<form method="POST" name="add_tag"
      action="<%=request.getContextPath()%>/add/${employee.id}">
    Tag: <input name="tag" value="${tag}" type="text" />
    <br/> <br/>
    <input value="Add tag" type="submit" />
</form>

<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${tags != null}">
        <h3>List of tags</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>Tag</th>
            </tr>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="t" items="${tags}">
                <tr>
                    <td>${t.tag.toString()}</td>
                    <td>
                        <a
                                href="<%=request.getContextPath()%>/update/tag/${t.id}">Update</a>
                        &nbsp; <a
                            href="<%=request.getContextPath()%>/delete/${employee.id}/tag/${t.id}"
                            onclick="return confirm('Do you really want to delete?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No Tags found in the DB for ${employee.name}!
    </c:otherwise>
</c:choose>

</body>
</html>