<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/custom.css">
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
        <th>Skills</th>
        </thead>
        <tbody>
        <c:forEach items="${projects}" var="project">
            <tr>
                <td>${project.name}</td>
                <td>${project.description}</td>
                <td>${project.quota}</td>
                <td>
                    <c:forEach items="${project.requiredSkills}" var="skill">
                        ${skill.name} <br>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
