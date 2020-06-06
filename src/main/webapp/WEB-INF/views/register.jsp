<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<jsp:include page="./layout/headlink.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<c:if test="${not empty message }">
			<div class="alert alert-info" role="alert">${message }</div>
		</c:if>
		<h1>Register</h1>
		<div class="error"><span></span></div>
		<spring:form modelAttribute="member" id="register-form"
			action="${pageContext.request.contextPath}/register" method="post">
			<div class="form-group ">
				<input type="text" class="form-control" id="userName"
					name="userName" placeholder="Username"> <span id="Uerror"></span>
			</div>
			<div class="form-group">
				<input type="email" class="form-control" id="email" name="email"
					placeholder="Email"> <span id="Eerror"></span>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="Password"
					name="password" id="password"> <span id="Perror"></span>
			</div>
			<div class="form-group">
				<input type="password" id="repassword" class="form-control"
					name="repassword" placeholder="RePassword"> <span
					id="RPerror"></span>
			</div>
			<button id="submit" type="submit" class="btn btn-success mb-2 w-100">Register</button>
		</spring:form>
		<a href="${pageContext.request.contextPath}/login">Click here to
			login</a>
	</div>
	<jsp:include page="./layout/js.jsp"></jsp:include>
</body>

</html>