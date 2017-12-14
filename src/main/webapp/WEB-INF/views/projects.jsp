<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/custom.css">
    <title>Projects</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1 id="pageHeader">List of Projects</h1>
    </div>
    <table class="table table-striped">
        <thead class="tableHeader">
        <th>Project Name</th>
        <th>Description</th>
        <th>Quota</th>
        <th>Students</th>
        </thead>
        <tbody>
        <c:forEach items="${projects}" var="project">
            <tr>
                <td>${project.name}</td>
                <td>${project.description}</td>
                <td>${project.quota}</td>
                <td>
                    <c:forEach items="${project.students}" var="student">
                        ${student.name} <br>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <label for="name"></label>
        <input type="text" id="name">

    </div>
</div>
</body>
</html>
