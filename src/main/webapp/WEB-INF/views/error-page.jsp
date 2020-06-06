<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Error</title>
	<jsp:include page="./layout/headlink.jsp" />
</head>
<body>
	<div class="container">
		<div class="text-center">
	 		<div class="error-server">
				<h2 style="color : red">${errorCode}</h2>
				<p style="color : red">${errorMessage} <a class="btn btn-danger" href="${pageContext.request.contextPath}">Back to Home</a></p>
	    	</div>
	    </div>
	</div>
	
</body>
</html>