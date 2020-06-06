<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="./layout/headlink.jsp"></jsp:include>
</head>
<body>
		<c:if test="${not empty message }">
			<div class="alert alert-danger text-center" role="alert">
				${message }</div>
		</c:if>
	<div class="container mt-5">


	</div>
	<div id="login">

		<h3 class="text-center text-white pt-5">Login form</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<spring:form id="form-login"
							action="${pageContext.request.contextPath}/login" method="post">
							<h3 class="text-center text-info">Login</h3>
							<div class="form-group">
								<label for="username" class="text-info">Username:</label><br>
								<input type="text" name="userName" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password" id="password"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="remember-me" class="text-info"> <span><input
										type="checkbox" id="remember-me" name="remember-me"></span> <span>Remember
										me</span> 
								</label><br> <input type="submit"
									class="btn btn-success btn-md w-100" value="Submit">
							</div>
							<div id="register-link" class="text-right">
								<a href="${pageContext.request.contextPath}/register"
									class="text-info">Register here</a>
							</div>
						</spring:form >
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./layout/js.jsp"></jsp:include>
</body>
</html>