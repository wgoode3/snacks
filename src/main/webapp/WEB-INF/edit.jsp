<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Snacks</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
    
        <h1>Edit the ${snack.name}</h1>
    
        <form:form action="/snacks/${snack.id}" method="post" modelAttribute="snack">
            <input type="hidden" name="_method" value="put">
            <div class="form-group">
                <label>Name:</label>
                <form:input path="name" class="form-control" />
                <form:errors path="name" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Flavor:</label>
                <form:input path="flavor" class="form-control" />
                <form:errors path="flavor" class="text-danger" />
            </div>
            <div class="form-group">
                <label>Calories:</label>
                <form:input type="number" path="calories" class="form-control" />
                <form:errors path="calories" class="text-danger" />
            </div>
            <input type="submit" value="Update Snack" class="btn btn-primary" />
         </form:form>
    </div>           
</body>
</html>