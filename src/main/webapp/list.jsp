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
  <c:when test="${not empty itemList && 0 < fn:length(itemList)}">
  	<table>
    <tr>
    	<th>ID</th>
    	<th>Name</th>
    	<th>Price</th>
    	<th>Add to Cart</th>
    </tr>
    <c:forEach var="item" items="${itemList }">
    	<tr>
      <td>
      	<a href="test.html?action=itemDetails&itemId=${item.id }">${item.id }</a>
      </td>
      <td>
      	<a href="test.html?action=itemDetails&itemId=${item.id }">${item.name }</a>
      </td>
      <td>
      	<a href="test.html?action=itemDetails&itemId=${item.id }">$ ${item.price }</a>
      </td>
      <td><form method="post" action="test.html">
        <input type="hidden" name="action" value="addToShoppingCart">
        <input type="hidden" name="itemId" value="${item.id }"><input
        	type="submit" name="submitButton" value="Add">
      	</form></td>
    	</tr>
    </c:forEach>
  	</table>
  </c:when>
  <c:otherwise>
  	<div>There is no item.</div>
  </c:otherwise>
	</c:choose>
	<p>This is incomplete. You should also have other features like
  moving back to the index page, viewing the item details, etc.</p>
</body>
</html>