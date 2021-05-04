<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<title>Spring Boot MVC and Hibernate CRUD Example</title>
<body>
<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Update Tug</h3>
<form method="POST" name="update_tag"
      action="<%=request.getContextPath()%>/update/tag">
    <input hidden="hidden" name="id" value="${id}" type="text"/>

    Tag: <input name="tag" value="${tags.tag}" type="text"/> <br/> <br/>

    <input value="Update Tag" type="submit"/>
</form>
</body>
</html>