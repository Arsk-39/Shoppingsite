<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>麺参館-TOP</title>
<link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/style.css">
<link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/home.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/heder.js"></script>
</head>
<body>
<header id="header">
  <h1 class="title">麺参館</h1>
  <nav class="nav">
    <ul class="menu-group">
      <li class="hed-menu"><a href="/ShoppingSiteSample/views/home.jsp">TOP</a></li>
      <li class="hed-menu"><form action="product" method="get"><input type="submit" value="お取り寄せ"></form></li>
      <li class="hed-menu"><form action="cart" method="get"><input type="submit" value="カートを見る"></form></li>
      <%
  HttpSession sesion = request.getSession();
  boolean isLoggedIn = (sesion.getAttribute("loggedInUser") != null);
%>
      <% if (isLoggedIn) { %>
        <li class="hed-menu"><form action="logout" method="post"><input type="submit" value="ログアウト"></form></li>
      <% } else { %>
        <li class="hed-menu"><form action="login" method="get"><input type="submit" value="ログイン"></form></li>
      <% } %>
    </ul>
  </nav>
</header>
<img src="../img/hed.jpg" width="100%">
<h2>当店のこだわり</h2>
<div class="detailed">

<img src="../img/tentyou.png" width="130px">
<p>//////////////////////////////////////////////////////////////////////////////////////////////////<br>
   //////////////////////////////////////////////////////////////////////////////////////////////////<br>
   //////////////////////////////////////////////////////////////////////////////////////////////////</p>
</div>
<h2>ニュース</h2>
<div class="news news-image">
<p>//////////////////////////////////////////////////////////////////////////////////////////////////</p>
<p>//////////////////////////////////////////////////////////////////////////////////////////////////</p>
<p>//////////////////////////////////////////////////////////////////////////////////////////////////</p>
<p>//////////////////////////////////////////////////////////////////////////////////////////////////</p>
</div>
<pre>

</pre>
This&nbsp;is&nbsp;a&nbsp;sentence&nbsp;with&nbsp;spaces.
<footer>
<p>Copyright2023　麵参館</p>
</footer>
</body>
</html>