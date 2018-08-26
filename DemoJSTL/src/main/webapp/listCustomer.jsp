<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>				
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td><c:out value="${customer.id}" /></td>
					<td><c:out value="${customer.name}" /></td>
					
					<td><a
						href="customer?accion=EDIT&id=<c:out value="${customer.id}"/>">Edit</a></td>
					<td><a
						href="customer?accion=DELETE&id=<c:out value="${customer.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form method="get" action="customer">
		<input type="hidden" name="accion" value="CREATE">
		<button>Create</button>
	</form>
</body>
</html>