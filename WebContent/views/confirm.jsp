<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8">
    <title>麺参館-購入確認</title>
    <link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/style.css">
    <link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/cart.css">
</head>
<body>
<body>
    <header>
        <h1 class="title">麺参館</h1>
        <nav class="nav">
            <ul class="menu-group">
        <li class="hed-menu"><a href="/ShoppingSiteSample/views/home.jsp">TOP</a></li>
        <li class="hed-menu"><form action="product" method="get"><input type="submit" value="お取り寄せ"></form></li>
        <li class="hed-menu"><form action="cart" method="get"><input type="submit" value="カートを見る"></form></li>
        <li class="hed-menu"><form action="logout" method="post"><input type="submit" value="ログアウト"></form></li>
      
               </ul>
        </nav>
    </header>
<!-- 他のHTMLコード -->
<h2>購入の確定</h2>
<h3>こちらでよろしいでしょうか？</h3>
<div class="center">
    <c:if test="${not empty cartList}">
    <table>
        <tr>
            <th>商品ID</th>
            <th>商品名</th>
            <th>価格(税込み)</th>
            <th>個数</th>
        </tr>
        <c:forEach items="${cartList}" var="cartItem">
        <c:if test="${cartItem.pcount != 0}">
            <tr>
                <td>|${cartItem.pid}|</td>
                <td>|${cartItem.pname}|</td>
                <td>|${cartItem.price * cartItem.pcount}|</td>
                <td>|${cartItem.pcount}|</td>
            </tr>
             </c:if>
        </c:forEach>
    </table>
     </c:if>
     </div>
<p>■名前</p>
<h3>${name}</h3>
<p>■住所</p>
<h3>${address}</h3>
<p>■電話番号(任意)</p>
<h3>${phoneNumber}</h3>
<p>■メールアドレス(任意)</p>
<h3>${mailAddress}</h3>
<form action="buy" method="post">
<input type="submit" value="購入">
<button type="button" onclick="history.back()">戻る</button>
</form>
<pre>

</pre>

<footer>
<p>Copyright2023　麵参館</p>
</footer>
</body>
</html>