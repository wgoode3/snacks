<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        
        <form action="/snacks" method="post">
            <div class="form-group">
                <label>Name:</label>
                <input type="text" name="name" class="form-control" />
            </div>
             <div class="form-group">
                <label>Flavor:</label>
                <input type="text" name="flavor" class="form-control" />
            </div>
             <div class="form-group">
                <label>Calories:</label>
                <input type="number" name="calories" class="form-control" />
            </div>
            <input type="submit" value="Add Snack" class="btn btn-primary" />
        </form>
        
        ${snacks}
        
    </div>

</body>
</html>