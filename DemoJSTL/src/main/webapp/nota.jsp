<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="nota" method="post">
		<label for="id">Nota ID</label>
		<input type="text" name="id" value="<c:out value="${nota.id }"/>" placeholder="ID"/>
		
		<label for="name">Nombre</label>
		<input type="text" name="name" value="<c:out value="${nota.name }"/>" placeholder="Nombre"/>
		
		<label for="grade">Nota</label>
		<input type="text" name="grade" value="<c:out value="${nota.grade }"/>" placeholder="Nota"/>
		
		<button type="submit" name="accion" value="<c:out value="${empty nota.id? 'CREATE':'UPDATE' }"/>">
			<c:out value="${empty nota.id? 'Crear':'Actualizar' }"/>
		</button>
	</form>
</body>
</html>