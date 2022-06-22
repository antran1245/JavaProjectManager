<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Manager Dashboard</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<header class="row d-flex align-items-center">
			<h1 class="heading-text col-8">Welcome, <c:out value="${user.getUserName()}"/>!</h1>
			<div class="col text-end">
				<a href="/logout">logout</a>
			</div>
		</header>
		<div class="row d-flex align-items-center">
			<p class="col m-0">All Project</p>
			<a href="/projects/new" class="col-3 btn btn-outline-primary">+ new project</a>
		</div>
		<div class="row">
			<table class="table tabel-striped">
				<thead>
					<tr>
						<th scope="col">Project</th>
						<th scope="col">Team Lead</th>
						<th scope="col">Due Date</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projects}">
						<c:if test="${project}"></c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<p>Your Projects</p>
		</div>
		<div class="row">
			<table class="table tabel-striped">
				<thead>
					<tr>
						<th scope="col">Project</th>
						<th scope="col">Team Lead</th>
						<th scope="col">Due Date</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projects}">
						<c:if test="${project}"></c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>