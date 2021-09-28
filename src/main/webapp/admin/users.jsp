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

		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
<h1>All Users</h1>
<div style="float:right; margin-right:260px">
<a href="/createUser" >Create </a>
</div>

   <table class="table">
     <thead>
       <tr>
         <th scope="col">ID</th>
         <th scope="col">Name</th>
         <th scope="col">Username</th>
         <th scope="col">Password</th>
         <th scope="col">Email</th>
         <th scope="col">Phone</th>
         <th scope="col">Is Active </th>
         <th scope="col">Action </th>
       </tr>
     </thead>
     <tbody>


     <c:forEach var = "user" items="${usersList}">
       <tr>
         <td>${user.id}</td>
          <td>${user.name}</td>
          <td>${user.username}</td>
          <td>${user.password}</td>
          <td>${user.email}</td>
          <td>${user.phone}</td>
          <td>${user.active}</td>
          <td>
          <a href="/viewUser?id=${user.id}">Details</a>
          <a href="/editUser?id=${user.id}">Edit</a>
          <a href="/deleteUser?id=${user.id}">Delete</a>


          </td>
       </tr>

       </c:forEach>


     </tbody>
   </table>



</body>
</html>