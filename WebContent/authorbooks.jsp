<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">    
 body{    
      background-image: url(images/249c4d2d527c1dff46c0a6eac3965895.jpg);    
   	  width:600px;height:600px;
      background-repeat: repeat-x;    
 }    
 </style>   
<body>
<br />
<br />
<br />
<center><b><h1>相关作者图书总览</h1><hr>
<br />
<table border = 2>
 <c:forEach items="${Booklist}" var="Book">
   <tr>
 <td><a href="book.jsp?ISBN=${Book.getISBN()}">${Book.getTitle()}</a></td>
    </tr>
 </c:forEach>
</table>
</body>
</html>