<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Personel Adres Ekleme</title>
<script>
	function geri() {
		window.location.href="<c:url value="/personelAdres" />?id=${param.id}";
	}
</script>
</head>
<body>
<form action="<c:url value="/personelAdres" />" method="post">
  <input type="hidden" name="id" value="${param.id}" />
  Adres: <input type="text" name="adres" /><br/><br/>
  <input type="submit" value="Ekle" />
  <input type="button" value="Geri" onclick="geri()"/>
</form>
</body>
</html>