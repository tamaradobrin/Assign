<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/custom.css">
    <title>Skills</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1 id="pageHeader">List of Skills</h1>
    </div>
    <table class="table table-striped">
        <thead class="tableHeader">
        <th>Skill Name</th>
        </thead>
        <tbody>
        <c:forEach items="${skillList}" var="skill">
            <tr>
                <td>${skill.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
