<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
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
	<div class="container-fluid">
		<jsp:include page="./layout/nav.jsp"></jsp:include>
		<div class="row">
			<div class="col col-lg-2">
				<jsp:include page="./layout/left.jsp"></jsp:include>
			</div>
			<div class="col col-lg-10 pt-4 pl-4">
				<div class="table">
					<table id="tbl-result" class="table table-bordered">
						<thead>
							<tr>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
				<div class="content">
					<div style="border-bottom: 1px solid back;">
						<h1>${submit }Content</h1>
					</div>
					<p class="text-center p">ALl field must input</p>
					<spring:form modelAttribute="content" id="form"
						action="${pageContext.request.contextPath}/${action}"
						method="post">
						<div class="form-group">
							<label for="title">Title</label> <input type="text"
								class="form-control" id="title" name="title"
								value="${content.title }" placeholder="Enter title">
						</div>
						<div class="form-group">
							<label for="brief">Brief</label> <input type="text"
								class="form-control" id="brief" id="brief" name="brief"
								value="${content.brief }" placeholder="Enter Brief">
						</div>
						<div class="form-group">
							<label for="content">Content</label> <input type="text"
								class="form-control" id="content" name="content"
								value="${content.content }" placeholder="Enter content">
						</div>

						<div class="form-group">
							<label for="sort">Sort</label> <input type="text"
								class="form-control" id="sort" name="sort"
								value="${content.sort }" placeholder="Enter sort">
						</div>
						<button id="content-button" type="submit" class="btn btn-primary-outline mb-2">${submit }</button>
						<button type="reset" class="btn btn-primary-outline mb-2">Reset</button>
					</spring:form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./layout/js.jsp"></jsp:include>
</body>

</html>