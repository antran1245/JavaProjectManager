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
    <title>Create a Project</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<header class="row"><h1>Create a Project</h1></header>
		<div class="row">
			<form:form method="post" modelAttribute="newProject">
				<div class="mb-3">
					<form:label class="form-label" path="title">Project Title </form:label>
					<form:input class="form-control" path="title"/>
					<form:errors path="title" class="text-danger"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="description">Project Description</form:label>
					<form:input class="form-control" path="description"/>
					<form:errors path="description" class="text-danger"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="dueDate">Due Date</form:label>
					<form:input type="date" class="form-control" path="dueDate"/>
					<form:errors class="text-danger" path="dueDate"/>
				</div>
				<div class="mb-3">
					<a href="/dashboard" class="w-25 btn btn-danger">Cancel</a>
					<button class="w-25 btn btn-outline-primary" type="submit">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>