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

	<form action="customer" method="post">
		
					<label for="id">Customer ID</label> 
					<input type="text" name="id"
						value="<c:out value="${customer.id}" />"
						placeholder="Customer ID" />
			
					<label for="name">Name</label> 
					<input type="text"
						name="name"
						value="<c:out value="${customer.name}" />"
						placeholder="Name" />
				
				
					<input type="submit" value="Create" />
				
	</form>

</body>
</html>