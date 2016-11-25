<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Play</title>
</head>
<body>

	<h1>JAEYOUNG's Dice Game!</h1>
	<h2>
		${username} dice ${curCell1} <br/> ${username} now dice value ${faceValue1} <br/><br/>
		 alpha dice ${curCell2} <br/> alpha now dice value ${faceValue2}
	</h2>
	<h3>
		<form id="roll" action="/webdicegame/roll" method="post">
			<button type="submit">Roll</button>
		</form><br/>
		<input type=button value="exit" onclick="self.close()">
	</h3>

</body>
</html>