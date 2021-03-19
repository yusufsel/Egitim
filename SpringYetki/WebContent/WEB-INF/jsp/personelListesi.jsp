<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Personel Listesi</title>
</head>
<body>
<c:forEach items="${liste}" var="p">
${p.adi}<br/>
</c:forEach>
</body>
</html>