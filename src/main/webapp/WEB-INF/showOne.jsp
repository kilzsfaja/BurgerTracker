<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showing Burger Jaunt</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<div class="row">
	<div class="col-10">
		<h1 class="my-5">Edit Burger</h1>
	</div>
	<div class="col-2">
	<a href="/burgers">Go back!</a>
	</div>
	</div>
		<div class="border mt-5 p-3">
			<form:form action="/burgers/process/edit/${burger.id }" method="post" modelAttribute="burger">
			<input type="hidden" name="_method" value="put"/>
		<div class="form-group">
			<label for="burgerName">Burger Name:</label>
			<form:input type="text" path="burgerName" class="form-control"/>
			<small class="form-text text-danger"><form:errors path="burgerName"/></small>
		</div>
		<div class="form-group">
			<label for="restaurantName">Restaurant Name:</label>
			<form:input type="text" path="restaurantName" class="form-control"/>
			<small class="form-text text-danger"><form:errors path="restaurantName"/></small>
		</div>
		<div class="form-group">
			<label for="notes">Notes:</label>
			<form:input type="text" path="notes" class="form-control"/>
			<small class="form-text text-danger"><form:errors path="notes"/></small>
		</div>
		<div class="form-group">
			<label for="rating">Rating:</label>
			<form:input type="number" path="rating" class="form-control"/>
			<small class="form-text text-danger"><form:errors path="rating"/></small>
		</div>
		<input type="submit" value="Edit Burger" class="mt-2 btn btn-success" />
	</form:form>
		</div>
	</div>
</body>
</html>