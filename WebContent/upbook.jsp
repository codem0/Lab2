<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
		request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update book</title>
</head>
<body>
<br />
<form action="upbook" method="post" >
<tr>
	<td> ISBN:</td><td><input name="Book.ISBN" value="<s:property value="Book.ISBN"/>"/></td>
</tr>
<tr>
	<td> Title:</td><td><input name="Book.Title" value="<s:property value="Book.Title"/>"/></td>
</tr>
<tr>
	<td> AuthorID:</td><td><input name="Book.AuthorID" value="<s:property value="Book.AuthorID"/>"/></td>
</tr>
<tr>
	<td> Publisher:</td><td><input name="Book.Publisher" value="<s:property value="Book.Publisher"/>"/></td>
</tr>
<tr>
	<td> PublishDate:</td><td><input name="Book.PublishDate" value="<s:property value="Book.PublishDate"/>"/></td>
</tr>
<tr>
	<td> Price:</td><td><input name="Book.Price" value="<s:property value="Book.Price"/>"/></td>
</tr>
<input type = 'submit' value="确认"/>
</form>
</body>
</html>