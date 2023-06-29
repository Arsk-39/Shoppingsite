<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>麺参館-メニュー</title>
<link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/style.css">
<link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/list.css">
<script src="../js/list.js"></script>
</head>
<body>
<%
  HttpSession sesion = request.getSession();
  boolean isLoggedIn = (sesion.getAttribute("loggedInUser") != null);
%>

<header>
  <h1 class="title">麺参館</h1>
  <nav class="nav">
    <ul class="menu-group">
      <li class="hed-menu"><a href="/ShoppingSiteSample/views/home.jsp">TOP</a></li>
      <li class="hed-menu"><form action="product" method="get"><input type="submit" value="お取り寄せ"></form></li>
      <li class="hed-menu"><form action="cart" method="get"><input type="submit" value="カートを見る"></form></li>
      
      <% if (isLoggedIn) { %>
        <li class="hed-menu"><form action="logout" method="post"><input type="submit" value="ログアウト"></form></li>
      <% } else { %>
        <li class="hed-menu"><form action="login" method="get"><input type="submit" value="ログイン"></form></li>
      <% } %>
    </ul>
  </nav>
</header>
    <h2>検索</h2>
    <form action="serch" method="get">
    <input type="text" name="keyword" placeholder="ワードで検索">
    <input type="submit" value="検索">
	</form>
    <h2>商品一覧</h2>
    <div class="sort">
    <button onclick="showOptions()">オプション表示</button>
  <form action="sortlist" method="get">
    <input type="hidden" name="sort" value="ascending">
    <input type="submit" value="価格(昇順)">
  </form>

  <form action="sortlist" method="get">
    <input type="hidden" name="sort" value="descending">
    <input type="submit" value="価格(降順)">
  </form>

  <form action="sortlists" method="get">
    <input type="hidden" name="sort" value="numberascending">
    <input type="submit" value="番号(昇順)">
  </form>

  <form action="sortlists" method="get">
    <input type="hidden" name="sort" value="numberdescending">
    <input type="submit" value="番号(降順)">
  </form>
</div>

<ul class="list_menu">
  <c:forEach items="${products}" var="product">
    <li class="product-item">
    <div>商品番号: ${product.pid}</div>
      <div><img src="../img/${product.pid}.png" width="25%"></div>
      <div>商品名: ${product.pname}</div>
      <div>価格(税込): ${product.price}円</div>
      <div>商品説明: ${product.pintro}</div>
      <form action="cartin" method="post">
        <input type="hidden" name="productId" value="${product.pid}">
        <input type="hidden" name="productName" value="${product.pname}">
        <input type="hidden" name="productPrice" value="${product.price}">
        <input type="number" name="productCount" value="1" min="1" max="10">
        <input type="submit" value="カートに追加">
      </form>
    </li>
  </c:forEach>
</ul>


    <pre>

</pre>

    <footer>
<p>Copyright2023　麵参館</p>
</footer>
</body>
</html>