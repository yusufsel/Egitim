<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Personel Adres Güncelle</title>
<script>
	function geri() {
		window.location.href="<c:url value="/personelListe" />";
	}
	function guncelle() {
		fetch('<c:url value="/personelAdres" />', 
			{
				method: 'PUT',
				body: JSON.stringify({adresId : '${adres.id}', adres: txtAdres.value})
			}
		).then(data => data.json())
		.then(cevap => {
			if (cevap.sonuc === 'ok') {
				window.location.href="<c:url value="/personelAdres" />?id=${adres.personel.id}";
			} else {
				alert(cevap.hata);
			}
		});
}
</script>
</head>
<body> 
<c:if test="${not empty mesaj}">
	<font color="blue"><b>${mesaj}</b></font>
</c:if>
<c:if test="${not empty hata}">
	<font color="red"><b>${hata}</b></font>
</c:if>
Adres: <input type="text" id="txtAdres" value="${adres.adres}" /><br/>
<input type="button" onclick="guncelle()" value="Güncelle" />
</body>
</html>