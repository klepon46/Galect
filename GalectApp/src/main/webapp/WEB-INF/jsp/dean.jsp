<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GA LECT</title>
</head>
<body>

	<form:form method="POST" action="/galect/dean/onSelectDepartment"
		modelAttribute="departement">
		<td><form:label path="departement">Department</form:label></td>
		<td><form:select path="departement" onchange="this.form.submit()">
				<form:option value="NONE" label="Select" />
				<form:options items="${deps}" itemValue="departmentName"
					itemLabel="departmentName" />
			</form:select></td>
	</form:form>
	
	<br/>
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Staff ID</th>
				<th>Student ID</th>
				<th>Rank</th>
				<th>Joining Date</th>
				<th>Scholarship Start Date</th>
				<th>Country</th>
				<th>University</th>
				<th>Department</th>
				<th>Major</th>
				<th>Email</th>
				<th>Mobile</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${employees}">
				<tr>
					<td>${item.employeeName}</td>
					<td>${item.staffID}</td>
					<td></td>
					<td>${item.rank}</td>
					<td>${item.joiningDate}</td>
					<td></td>
					<td></td>
					<td></td>
					<td>${item.department}</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>