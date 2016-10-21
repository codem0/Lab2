<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>book info</title>
 <style type="text/css">    
 body{    
      background-image: url(images/12a58PICBfM_1024.jpg);    
      background-repeat: repeat-x;    
 }    
 </style>    
</head>
<body>
      <br />
      <br />
       <br />
        <br />
         <br />
      <center><b><h1>相关图书信息</h1><hr>
      <br />
     
      <table border = 3>
     	 <tr><td><b><center>ISBN</td>
        	 <td><b><center>title</td>
       		 <td><b><center>AuthorID</td>
        	 <td><b><center>Publisher</td>
        	 <td><b><center>PublishDate</td>
        	 <td><b><center>Price</td>
      </tr>
      <c:forEach items="${Booklist}" var="Book">
      <c:choose>
	  <c:when test="${Book.getISBN()==param.ISBN}">
      <tr>
        <td>${Book.getISBN()}</td>
        <td>${Book.getTitle()}</td>
        <td>${Book.getAuthorID()}</td>
        <td>${Book.getPublisher()}</td>
        <td>${Book.getPublishDate()}</td>
        <td>${Book.getPrice()}</td>
      </tr>
      </c:when>
      </c:choose>
      </c:forEach>
  	</table>
  	</table>
  	 <br />
  	  <br />
  	<table align="center">
	 <table border = 3>
		<tr>
			<th>AuthorID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Country</th>
		</tr>
		<tr>
			<td>${Author.getAuthorID()}</td>
			<td>${Author.getName()}</td>
			<td>${Author.getAge()}</td>
			<td>${Author.getCountry()}</td>
		</tr>	  	
  	</table>
</body>
</html>