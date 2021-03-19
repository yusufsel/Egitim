<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Birlik �al��an Say�lar�</title>
</head>
<body>
  <table>
    <tr>
      <th>Birlik Id</th>
      <th>�al��an Say�s�</th>
    </tr>
    <c:forEach items="${liste}" var="b">
      <tr>
        <td style="text-align: center">${b.key}</td>
        <td style="text-align: center">${b.value}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>