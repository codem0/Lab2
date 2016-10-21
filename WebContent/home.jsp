<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
		request.getServerPort() + path;
%>
<jsp:directive.page import="book_action.DAO" />
<jsp:directive.page import="java.util.List" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath %>"/>
<title>homepage</title>    
 <style type="text/css">   
  body{    
      background-image: url(images/069c9c06f94ee053d85b9afcc920bd9e.jpg);    
      background-repeat: repeat-x;    
 }   

 </style>    
</head>
<body>
   
   
   <%
   List Booklist=DAO.getBook();
   request.setAttribute("Booklist",Booklist);
    %>

<br />
<br />
<br />
    <center><b><h1>图书浏览信息</h1><hr>
    <hr>
    <br />
    <br />
    <table border = 3>
      <tr>
      	<td><b><center>书名</td>
      	<td><b><center>删除</td>
      	<td><b><center>更新</td>
      </tr>
      <c:forEach items="${Booklist}" var="Book">
      <tr>
        <td><a href="show?ISBN=${Book.getISBN()}">${Book.getTitle()}</a></td>
     	<td><a href="delete?ISBN=${ Book.getISBN()}"> 删除</a></td>
     	<td><a href="query?ISBN=${ Book.getISBN()}"> 更新</a></td>
    </tr>
    	</c:forEach>
    	
    	<form action="author" method="post">
    <table align="center">
       <h2>查询相关作者</h2>
       <td><input  name=name></td><tr>
       <th><h3><input type="submit" value="确认"></h3></th></tr>
    	 
    </table>
    	<a href='add.jsp'><h2>添加图书</h2></a>
  	</table>
  </form>
  
  
</body>
</html>