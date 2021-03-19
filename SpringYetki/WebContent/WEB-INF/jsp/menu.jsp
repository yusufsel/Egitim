<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/WEB-INF/yetki.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Insert title here</title>
</head>
<body>
${hata}<br/>

<!-- 
<c:set var="personelListeYetki" value="false" />
<c:set var="personelYaratmaYetki" value="false" />
<c:forEach var="yetki" items="${yetkiler}">
  <c:if test="${yetki.yetki.id eq 1}">
    <c:set var="personelListeYetki" value="true" />
  </c:if>
  <c:if test="${yetki.yetki.id eq 2}">
    <c:set var="personelYaratmaYetki" value="true" />
  </c:if>
</c:forEach>
 -->
yetki sayısı:  ${fn:length(yetkiler)}<br/>

<f:yetki yetkiId="YETKI_PERSONEL_LISTELEME"><a href="<c:url value="/personelListele" />">Personel Listesi</a><br/></f:yetki>
<f:yetki yetkiId="YETKI_PERSONEL_YARATMA"><a href="<c:url value="/personelYarat" />">Personel Yaratma</a><br/></f:yetki>
<!--  
<c:if test="${personelListeYetki}">
  <a href="<c:url value="/personelListele" />">Personel Listesi</a><br/>
</c:if>
<c:if test="${personelYaratmaYetki}">
  <a href="<c:url value="/personelYarat" />">Personel Yaratma</a><br/>
</c:if>
-->
</body>
</html>