<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>麺参館-カート</title>
    <link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/style.css">
    <link rel="stylesheet" type="text/css" href="/ShoppingSiteSample/css/cart.css">
</head>
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
    
    <h1>カート</h1>

    <h2>商品一覧</h2>
    <div class="center">
    <c:if test="${not empty cartList}">
    <table>
        <tr>
            <th>商品ID</th>
            <th>商品名</th>
            <th>価格(税込)</th>
            <th>商品イメージ</th>
            <th>個数</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${cartList}" var="cartItem">
        <c:if test="${cartItem.pcount != 0}">
            <tr>
                <td>|${cartItem.pid}|</td>
                <td>|${cartItem.pname}|</td>
                <td>|${cartItem.price * cartItem.pcount}|</td>
                <td><img src="../img/${cartItem.pid}.png" width="25%" ></td>
                <td>|${cartItem.pcount}|</td>
                <td>
                
               <form action="cartadd" method="post">
    			  <input type="hidden" name="productId" value="${cartItem.pid}">
                 <input type="number" name="Count" value="1" min="1" max="${cartItem.pcount}">
    			<input type="submit" name="add" value="+">
    			<input type="submit" name="delete" value="-">
				</form>

				

                </td>
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
    
    <p>
       <c:if test="${totalPrice > 0}">
       <form action="cartdelete" method="post">
                <input type="submit" name="all" value="全消去">
           </form>
            <form action="purchase" method="post">
                <input type="submit" value="購入">
            </form>
        </c:if>
    </p>
    <pre>

</pre>

    <footer>
<p>Copyright2023　麵参館</p>
</footer>
</body>
</html>
