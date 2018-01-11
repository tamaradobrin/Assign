<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/custom.css">
    <title>Upload Document</title>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1 id="pageHeader">Upload Document</h1>
    </div>
    <form:form action="/upload" method="post" enctype="multipart/form-data" modelAttribute="document">
        <div class="form-group">
            <form:label path="content">Upload a document: </form:label>
            <form:input class="form-control-file grey" type="file" path="content"/>
        </div>
        <button type="submit" class="btn btn-primary">Upload</button>
    </form:form>
</div>
</body>
</html>
