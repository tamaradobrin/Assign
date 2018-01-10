<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/custom.css">
    <title>Register User</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1 id="pageHeader">Register User</h1>
    </div>
    <form:form method="post" action="/register" modelAttribute="user">
        <div class="form-group">
            <form:label path="username">Username: </form:label>
            <form:input type="text" path="username"/>
        </div>
        <div class="form-group">
            <form:label path="password">Password: </form:label>
            <form:input type="password" path="password"/>
        </div>
        <div class="form-group">
            <form:label path="usergroup">User Group: </form:label>
            <form:select class="form-control" path="usergroup">
                <c:forEach items="${groups}" var="groupName">
                    <option>${groupName}</option>
                </c:forEach>
            </form:select>
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
    </form:form>
</div>
</body>
</html>
