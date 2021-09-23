<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>All Students</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
		<link rel="stylesheet"
        		href="css/ismt.css">
</head>

<body>
<div class="container" >
<div class="alert alert-success" role="alert">
  ID : ${ourUser.id}
</div>
<div class="alert alert-success" role="alert">
  Name : ${ourUser.name}
</div>
<div class="alert alert-success" role="alert">
 Email : ${ourUser.email}
</div>
<div class="alert alert-success" role="alert">
  Phone : ${ourUser.phone}
</div>
<div class="alert alert-success" role="alert">
  Username : ${ourUser.username}
</div>

<div class="alert alert-success" role="alert">
  Password : ${ourUser.password}
</div>
<div class="alert alert-success" role="alert">
  Status :  ${ourUser.active}
</div>
</div>


</body>
</html>
