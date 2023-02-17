<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Travel Tracker</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body style="margin:10vw;">
	<h1>Travel Tracker</h1>
	<table class="table table-striped tabled-bordered">
		<thead>
			<tr>
				<th>Expense Name:</th>
				<th>Vendor:</th>
				<th>Amount:</th>
				<th>Description:</th>
				<th>Action</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="travel" items="${travels}">
				<tr>
					<td><a href="/travel/${travel.id}"><c:out value="${travel.expense}"/></a></td>
					<td><c:out value="${travel.vendor}"/></td>
					<td><c:out value="${travel.amount}"/></td>
					<td><c:out value="${travel.description}"/></td>
					<td><a href="/edit/${travel.id}">Edit</a></td>
					<td>
						<form action="/travel/delete/${travel.id}" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="Delete" class="btn btn-danger">
						</form>
					</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<h2>Add an expense:</h2>
	<form:form action="/addTravel" mode="post" modelAttribute="travel">
		<div>
		<form:label path="expense">Expense Name:</form:label><br>
		<form:errors path="expense" class="text-danger"/>
		<form:input path="expense" style="width:250px;"/>
		</div>
		<div>
		<form:label path="vendor">Vendor:</form:label><br>
		<form:errors path="vendor" class="text-danger"/>
		<form:input path="vendor" style="width:250px;"/>
		</div>
		<div>
		<form:label path="amount">Amount:</form:label><br>
		<form:errors path="amount" class="text-danger"/>
		<form:input path="amount" style="width:250px;"/>
		</div>
		<div>
		<form:label path="description">Description:</form:label><br>
		<form:errors path="description" class="text-danger"/>
		<form:input path="description" style="width:250px;"/>
		</div>
		<div>
		<input type="submit" value="Submit"/>
		</div>
	</form:form>
	
</body>
</html>