<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>All Students</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>

    SUCCESS  !!!

<br>
<h1>
${institution}
</h1>

<h1>
${phoneNumber}
</h1>


<h1>
${apple}
</h1>
<h1>
${ball}
</h1>
<h1 style="color:green">
${cat.name}
</h1>

<h1 style="color:green">
${cat.color}
</h1>
<h1>
${dog}
</h1>




        <c:forEach var = "student" items="${ss}">
        <p style="color:red">${student.id} </p>
        <p style="color:red">${student.firstName} </p>
                <p style="color:red">${student.lastName} </p>
                        <p style="color:red">${student.email} </p>
                                                <p style="color:red">${student.phone} </p>




        <br>
          </c:forEach>




</body>
</html>