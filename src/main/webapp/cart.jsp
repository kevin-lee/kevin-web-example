<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Item List</h2>
	<c:choose>
  <c:when
  	test="${not empty shoppingCart && 0 < fn:length(shoppingCart.allLineItems)}">
  	<form method="post" action="test.html">
    <input type="hidden" name="action" value="updateShoppingCart">
    <table>
    	<tr>
      <th>ID</th>
      <th>Name</th>
      <th>Price</th>
      <th>Quantity</th>
      <th>Line Total</th>
      <th>Remove</th>
    	</tr>
    	<c:forEach var="lineItem" items="${shoppingCart.allLineItems }">
      <tr>
      	<c:set var="item" value="${lineItem.item }" />
      	<td>${item.id }<input type="hidden" name="itemId"
        value="${item.id }"></td>
      	<td>${item.name }</td>
      	<td>$ ${item.price }</td>
      	<td><input type="text" name="quantity"
        value="${lineItem.quantity }"></td>
      	<td>$ ${lineItem.lineTotal }
      	<td><a
        href="test.html?action=removeItemFromShoppingCart&itemId=${item.id }">Remove
        	(Not working)</a></td>
      </tr>
    	</c:forEach>
    </table>
  	<div><b>Total: (Should be implemented!)</b></div>
  	<div><input type="submit" value="Update (Not working)"></div>
  	</form>
  	<p>
    <strong>There must be other functions such as Check out,
    	Clear shopping cart, Continue shopping and so on.</strong>
  	</p>
  </c:when>
  <c:otherwise>
  	<div>There is no item in your shopping cart.</div>
  </c:otherwise>
	</c:choose>
</body>
</html>