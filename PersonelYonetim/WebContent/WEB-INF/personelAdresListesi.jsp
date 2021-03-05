<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Personel Adres Listesi</title>
<script>
	function geri() {
		window.location.href="<c:url value="/personelListe" />";
	}
	function sil(adresId) {
		if (confirm('Bu adresi silmek istediğinizden emin misiniz?')) {
			fetch('<c:url value="/personelAdres" />?id='+adresId, {method: 'DELETE'}
			).then(
				request => {
					window.location.href="<c:url value="/personelAdres" />?id=${param.id}";
				}
			);
		}
	}
</script>
</head>
<body> 
<c:if test="${not empty mesaj}">
	<font color="blue"><b>${mesaj}</b></font>
</c:if>
<table border="1">
 <tr>
 	<th>Adres</th>
 	<th>&nbsp;</th>
 </tr>
 <c:forEach items="${liste}" var="personelAdres">
 	<tr>
 		<td>${personelAdres.adres}</td>
 		<td><a href="#" onclick="sil(${personelAdres.id})">Sil</a></td>
 	</tr>
 </c:forEach>
</table>
<br/>
<form action="<c:url value="/personelAdresEkle.jsp" />" method="post">
    <input type="hidden" name="id" value="${param.id}" />
	<input type="submit" value="Ekle" />
	<input type="button" value="Geri" onclick="geri()"/> 
</form>
</body>
</html>