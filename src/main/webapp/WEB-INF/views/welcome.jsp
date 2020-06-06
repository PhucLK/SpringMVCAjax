<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="./layout/headlink.jsp"></jsp:include>
<body>
	<jsp:include page="./layout/nav.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<div class="col col-lg-2">
				<jsp:include page="./layout/left.jsp"></jsp:include>
			</div>

			<div class="col col-lg-10 pt-4 pl-4">
				<h1>Welcome Member</h1>

				<table id="tbl-result" class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Title</th>
							<th scope="col">Brief</th>
							<th scope="col">Content</th>
							<th scope="col">Created Date</th>
							<th scope="col" colspan="2">Option</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>

				<div class="test"></div>
			</div>
		</div>
	</div>
	
	<jsp:include page="./layout/js.jsp"></jsp:include>
</body>


</html>