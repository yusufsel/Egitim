<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Kullanıcı Yaratma Ekranı</title>
</head>
<body>
<c:if test="${not empty hata}">
<font color="red"><b>${hata}</b></font>
</c:if>
<form action="<c:url value="/kullaniciYarat" />" method="post">
  <table>
    <tr>
      <td>Adı: </td>
      <td><input type="text" name="adi" /></td>
    </tr>
    <tr>
      <td>Soyadı: </td>
      <td><input type="text" name="soyadi" /></td>
    </tr>
    <tr>
      <td>T.C No: </td>
      <td><input type="text" name="tcno" /></td>
    </tr>
    <tr>
      <td>Şifre:</td>
      <td><input type="password" name="sifre" /></td>
    </tr>
  </table>
  <input type="submit" value="Kullanıcı Yarat" />
</form>
<a href="<c:url value="/" />">Geri</a>
</body>
</html>