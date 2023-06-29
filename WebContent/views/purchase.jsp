<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
    
    <h1>購入画面</h1>

    <h2>カート一覧</h2>
    <div class="center">
    <c:if test="${not empty cartList}">
    <table>
        <tr>
            <th>商品ID</th>
            <th>商品名</th>
            <th>価格</th>
            <th>個数</th>
        </tr>
        <c:forEach items="${cartList}" var="cartItem">
        <c:if test="${cartItem.pcount != 0}">
            <tr>
                <td>${cartItem.pid}</td>
                <td>${cartItem.pname}</td>
                <td>${cartItem.price * cartItem.pcount}</td>
                <td>${cartItem.pcount}</td>
            </tr>
             </c:if>
        </c:forEach>
    </table>
     </c:if>
     </div>
    <h2>合計価格</h2>
    <p>
        <c:set var="totalPrice" value="0" />
        <c:forEach items="${cartList}" var="cartItem">
            <c:set var="totalPrice" value="${totalPrice + (cartItem.price * cartItem.pcount)}" />
        </c:forEach>
        合計価格: ${totalPrice}
    </p>
    <p>こちらで大丈夫でしょうか？大丈夫でしたらお支払方法、住所をお書きください。</p>
<form action="confirm" method="post">
    <p>■名前</p>
<input type="text" name="NAME" required>
	<p>■住所</p>
  <input tyep="text" name="ADDRESS" required><br>
<p>■電話番号(任意)</p>
<input type="tel" name="PHONE_NUMBER" size="12" maxlength="12"><br>
<p>■メールアドレス(任意)</p>
<input type="text" name="MAIL_ADDRESS" size="30" maxlength="30">
<br>
<input type="submit" value="購入">
<input type="reset" value="リセット" name="rest">
    </form>
    <pre>

</pre>
<footer>
<p>Copyright2023　麵参館</p>
</footer>
</body>
</html>