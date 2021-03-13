<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Personel Resmi Değiştirme</title>
</head>
<body>
<img style="width: 100px" src="<c:url value="/personelResim" />?id=${param.id}" />
  <form method="post" enctype="multipart/form-data" action="<c:url value="/personelResim" />">
    <input type="hidden" name="id" value="${param.id}" />
    <input type="file" name="resim" /><br /> <br /> 
    <input type="submit" value="Resmi Değiştir" />
  </form>
</body>
</html>