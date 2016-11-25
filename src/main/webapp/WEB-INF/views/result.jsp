<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Result</title>
</head>
<body>

	<h1>JAEYOUNG's Dice Game!</h1>
	<c:if test="${winner=='draw'}">
		<h2> Draw !! </h2>
	</c:if>
	
	<c:if test="${winner!='draw'}">
	<h2> ${winner} Win!! </h2>
	</c:if>

	<h3>
	
	<form name ="Score" action="/webdicegame/score" method ="post">
	<button type="submit">Score</button>
	</form>
	
	<br/>
		<input type=button value="Exit" onclick="self.close()">
	</h3>


</body>
</html>