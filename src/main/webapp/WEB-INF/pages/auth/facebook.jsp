<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>DEMO - Login With Facebook using Java</title>
  <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<div style="width:400px;margin:auto;padding-top:30px;">
  <table class="table table-bordered">
    <tr>
      <td>Pic</td>
      <td><img src="http://graph.facebook.com/${user.id}/picture"/></td>
    </tr>
    <tr>
      <td>User ID</td>
      <td>${user.id}</td>
    </tr>
    <tr>
      <td>Email</td>
      <td>${user.email}</td>
    </tr>
    <tr>
      <td>Name</td>
      <td>${user.name}</td>
    </tr>
  </table> 
</div>

</body>
</html>