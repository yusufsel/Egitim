<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Giri� Ekran�</title>
</head>
<body>
<form action="<c:url value="/giris" />" method="post">
  <table>
    <tr>
      <td>T.C No: </td>
      <td><input type="text" name="tcno" /></td>
    </tr>
    <tr>
      <td>�ifre:</td>
      <td><input type="password" name="sifre" /></td>
    </tr>
  </table>
  <input type="submit" value="Giri� Yap" />
</form>
</body>
</html>