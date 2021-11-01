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
<h1>All Categorys</h1>
<div style="float:right; margin-right:260px">
<a href="/createCategory" >Create </a>
</div>

   <table class="table">
     <thead>
       <tr>
         <th scope="col">ID</th>
         <th scope="col">Name</th>
         <th scope="col">Description</th>
           <th scope="col">Action</th>


       </tr>
     </thead>
     <tbody>


     <c:forEach var = "cat" items="${categories}">
       <tr>
         <td>${cat.id}</td>
          <td>${cat.name}</td>
          <td>${cat.description}</td>

          <td>
          <a href="/viewCategory?id=${user.id}">Details</a>
          <a href="/editCategory?id=${user.id}">Edit</a>
          <a href="/deleteCategory?id=${user.id}">Delete</a>


          </td>
       </tr>

       </c:forEach>


     </tbody>
   </table>



</body>
</html>