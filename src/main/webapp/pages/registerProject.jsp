<%@ taglib prefix="form" uri="http://java.sun.com/jsf/html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/custom.css">
    <title>Register Project</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1 id="pageHeader">Register Project</h1>
    </div>
    <form action="/projects/register" method="post">
        <div class="form-group">
            <label class="tableHeader" for="name">Project Name</label>
            <input class="form-control formInput" id="name" name="name" placeholder="Enter project name" type="text" size="200"
                   maxlength="200">
        </div>
        <div class="form-group">
            <label class="tableHeader" for="description">Description</label>
            <textarea class="form-control formInput" id="description" name="description" placeholder="Enter a description for the project"
                      rows="3"></textarea>
        </div>
        <div class="form-group">
            <label class="tableHeader" for="quota">Quota</label>
            <input class="form-control formInput" id="quota" name="quota" placeholder="Enter project quota" type="number">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
