<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>İsimler</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	let isimSayisi = 0;
	let isimOkunmadiTamamlandi = false;
	function isimGetir() {
		if (!isimOkunmadiTamamlandi) {
    		fetch('<c:url value="/isimler" />', {
    			method: 'POST',
    			body: JSON.stringify({ isimSayisi })
    		}).then(data => data.json())
    		.then(data => {
    			let isimlerHTML = '';
    			let isimArr = data.liste;
    			for(let i = 0;i<isimArr.length;i++) {
    				let isim = isimArr[i].isim;
    				let id = isimArr[i].id;
    				isimlerHTML += id+ " - " + isim + '<br/>';
    			}
    			document.querySelector('#isimlerDiv').innerHTML += isimlerHTML;
    			isimSayisi += isimArr.length;
    			if (isimArr.length<100) {
    				// sunucudan alınacak isimler bitti.
    				console.log("isimlerin okunması tamamlandı.");
    				isimOkunmadiTamamlandi = true;
    			}
    		});
		}
	}
	function ekranScroll() {
		// sayfanın en altına gelindiğinde scroll yapsın.
		if ($(window).scrollTop() >= ($(document).height() - $(window).height()) * 1) {
			isimGetir();
		};
	}
	document.addEventListener('scroll', ekranScroll);
	
</script>
</head>
<body>
<input type="button" onclick="isimGetir()" value="İsimleri Getir"/>
<div id="isimlerDiv"></div>
<!-- 
<form action="ftest" method="post" enctype="multipart/form-data">
<input type="file" name="f" />
<input type="submit" value="submit" />

 -->
 </form>
</body>
</html>