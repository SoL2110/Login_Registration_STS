<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table style="border-collapse: collapse; border: 1px solid #000;">
    <tr>
        <th style="padding: 2px; border: 1px solid #000;">First Name</th>
        <th style="padding: 2px; border: 1px solid #000;">Last Name</th>
        <th style="padding: 2px; border: 1px solid #000;">Email</th>
        <th style="padding: 2px; border: 1px solid #000;">Mobile</th>
    </tr>
    <c:forEach var="registration" items="${registrations}">
        <tr>
            <td style="padding: 2px; border: 1px solid #000;">${registration.firstName}</td>
            <td style="padding: 2px; border: 1px solid #000;">${registration.lastName}</td>
            <td style="padding: 2px; border: 1px solid #000;">${registration.email}</td>
            <td style="padding: 2px; border: 1px solid #000;">${registration.mobile}</td>
            <td style="padding: 2px; border: 1px solid #000;"><a href="delete-registration?id=${registration.id}">Delete</a></td>
            <td style="padding: 2px; border: 1px solid #000;"><a href="update-registration?id=${registration.id}">Update</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>