<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Score</title>
</head>
<body>

<h1>
	JAEYOUNG's Dice Game!
</h1>

	
	<h2>Score</h2>

	<c:forEach  var="scores" items="${scores}">
	${scores.name} : </t> ${scores.win} win, </t> ${scores.lose} lose, </t> ${scores.draw} draw<br>
	</c:forEach>
	<form id ="Home" action="/webdicegame/" method="get">
	<button type="submit">home</button></form>
	<br/>
	<input type=button value="Exit" onclick="self.close()">
	
</body>
</html>