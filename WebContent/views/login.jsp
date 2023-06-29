<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>麺参館-ログイン</title>
<link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/style.css">
</head>
<body>
<header>
    <h1 class="title">麺参館-ログイン</h1>
    <li class="hed-menu"><a href="/ShoppingSiteSample/views/home.jsp">TOP</a></li>
  </header>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errormsg != null }">${errormsg}</c:if>
<c:remove var="errormsg"/>
<c:if test="${logout != null }">${logout}</c:if>
<c:remove var="logout"/>
<%
  String logoutMessage = request.getParameter("logout");
  if (logoutMessage != null && !logoutMessage.isEmpty()) {
%>
<div class="logout-message"><%= logoutMessage %></div>
<%
  }
%>
<p>パスワード</p>
<form action="login" method="post">
<input type="text" name="member_id">
<input type="password" name="password">
<input type="submit" value="ログイン">
</form>
<footer>
<p>Copyright2023　麵参館</p>
</footer>
</body>
</html>