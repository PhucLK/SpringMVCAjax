<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="input-group md-form form-sm form-2 pl-0 mt-4 pb-3">
	<input id="text" class="form-control my-0 py-1 red-border" type="text"
		placeholder="Search" aria-label="Search">
	<div class="input-group-append">
		<button class="btn-primary-outline " id="search">
			<i class="fa fa-search" aria-hidden="true"></i>
		</button>
	</div>
</div>

<button class="btn btn-primary-outline mt-5 pl-0" id="view-content"
	style="border: none">
	<i class="fa fa-list" aria-hidden="true"></i>View content
</button>
<br>
<a class="mt-3" href="${pageContext.request.contextPath}/add"><i
	class="fa fa-pencil-square-o" aria-hidden="true"></i>Form content</a>



