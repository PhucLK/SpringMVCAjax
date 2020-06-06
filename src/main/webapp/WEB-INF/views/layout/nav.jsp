
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="nav">
	<h2 class="">
		<a href="${pageContext.request.contextPath}/home">&nbsp;&nbsp;Home</a>
	</h2>
	<div class="dropdown dropdown-menu-right">
		<button type="button" class="btn btn-primary-outline dropdown-toggle"
			data-toggle="dropdown">
			<i class="fa fa-user-o" aria-hidden="true"></i>
		</button>
		<div class="dropdown-menu dropdown-menu-right">
			<a class="dropdown-item"
				href="${pageContext.request.contextPath}/profile"><i
				class="fa fa-user" aria-hidden="true"></i>User Profile</a> <a
				class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i
				class="fa fa-sign-out" aria-hidden="true"></i>LogOut</a>
		</div>
	</div>
</nav>