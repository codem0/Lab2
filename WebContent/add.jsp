<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addbook" method="post" >
<tr>
	<td> ISBN:</td><td><input name="Book.ISBN" value=""/></td>
</tr>
<tr>
	<td> Title:</td><td><input name="Book.Title" value=""/></td>
</tr>
<tr>
	<td> AuthorID:</td><td><input name="Book.AuthorID" value=""/></td>
</tr>
<tr>
	<td> Publisher:</td><td><input name="Book.Publisher" value=""/></td>
</tr>
<tr>
	<td> PublishDate:</td><td><input name="Book.PublishDate" value=""/></td>
</tr>
<tr>
	<td> Price:</td><td><input name="Book.Price" value=""/></td>
</tr>
<input type = 'submit' value="确认"/>
</body>
</html>