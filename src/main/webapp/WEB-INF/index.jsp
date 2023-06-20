<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Jaunt</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="my-5">Burger Tracker</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="burger" items="${allBurgers}">
				<tr>
					<td><c:out value="${burger.burgerName}"/></td>
					<td><c:out value="${burger.restaurantName}"/></td>
					<td><c:out value="${burger.rating}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="border mt-5 p-3">
			<form:form action="/burgers/create" method="post" modelAttribute="burger">
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
		<input type="submit" value="Add Burger" class="mt-2 btn btn-success" />
	</form:form>
		</div>
	</div>
</body>
</html>