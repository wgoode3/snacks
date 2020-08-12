<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
        <div class="jumbotron">
            <h1>Snacks</h1>
        </div>
        
        <div class="row">
            <div class="col-sm-4">
                <form:form action="/snacks" method="post" modelAttribute="snack">
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
                    <input type="submit" value="Add Snack" class="btn btn-primary" />
                </form:form>           
            </div>
            <div class="col-sm-8">  
                <form class="form-inline mb-3">
                    <input type="search" placeholder="Search" name="q" class="form-control" />
                    <input type="submit" value="Search" class="btn btn-outline-info" />
                </form>
                <table class="table table-striped">
                    <tbody>
                        <tr>
                            <th>Snack Name</th>
                            <th>Flavor</th>
                            <th>Calories</th>
                            <th>Actions</th>
                        </tr>
                        <c:forEach items="${all}" var="s">
                            <tr>
                                <td>${s.name}</td>
                                <td>${s.flavor}</td>
                                <td>${s.calories} Calories</td>
                                <td>
                                    <a class="btn btn-info btn-sm" href="/snacks/${s.id}">Edit</a>
                                    <a class="btn btn-danger btn-sm" href="/snacks/${s.id}/remove">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>  
            </div>
        </div>
        
        ${healthyOptions}
    </div>

</body>
</html>