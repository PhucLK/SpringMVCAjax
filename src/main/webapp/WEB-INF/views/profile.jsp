<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>

	<jsp:include page="./layout/nav.jsp"></jsp:include>

	<div class="container-fluid">
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
				<div class="profile">
					<div style="border-bottom: 1px solid back;">
						<h1>Edit Profile</h1>
					</div>
					<spring:form action="${pageContext.request.contextPath}/profile"
						method="post" modelAttribute="member">
						<div class="form-group">
							<label for="firstname">First Name</label> <input type="text"
								class="form-control" id="firstname" name="firstName"
								value="${member.firstName }" placeholder="Enter the first name">
						</div>
						<div class="form-group">
							<label for="lastname">Last Name</label> <input type="text"
								class="form-control" id="lastname" name="lastName"
								value="${member.lastName }" placeholder="Enter the last name">
						</div>
						<div class="form-group">
							<label for="Email">Email</label>
							<p>${member.email }</p>
						</div>
						<div class="form-group">
							<label for="Phone">Phone</label> <input type="text" name="phone"
								class="form-control" id="Phone" value="${member.phone }"
								placeholder="Enter the phone number">
						</div>
						<div class="form-group">
							<label for="message">Description</label>
							<textarea class="form-control" id="message" rows="3"
								name="description" placeholder="Enter your description">${member.description }</textarea>
						</div>
						<button type="submit" class="btn btn-primary-outline mb-2">Submit</button>
						<button type="reset" class="btn btn-primary-outline mb-2">Reset</button>
					</spring:form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="./layout/js.jsp"></jsp:include>
</body>

</html>