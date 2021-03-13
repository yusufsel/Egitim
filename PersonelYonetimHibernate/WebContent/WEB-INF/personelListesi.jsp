<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Personel Listesi</title>
</head>
<body>
  <c:if test="${not empty hata}">
    <font color="red"><b>${hata}</b></font>
  </c:if>
  <table border="1">
    <tr>
      <th>Personel Adı</th>
      <th>&nbsp;</th>
      <th>Personel Resmi</th>
      <th>&nbsp;</th>
    </tr>
    <c:forEach items="${liste}" var="personel">
      <tr>
        <td>${personel.adi}</td>
        <td><a href="<c:url value="/personelAdres" />?id=${personel.id}">Adresleri</a></td>
        <td><img style="width: 100px" src="<c:url value="personelResim" />?id=${personel.id}" /></td>
        <td><a href="<c:url value="/personelResimDegistir.jsp" />?id=${personel.id}">Resim Değiştir</a></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>