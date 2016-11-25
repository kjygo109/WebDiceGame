<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	JAEYOUNG's Dice Game!
</h1>

<form name="PlayGame" action="/webdicegame/play" method="post">
		<input type="text" name="username" id="username" required="" />
		<button type="submit">Play</button> <br/></form>
		<form id ="Home" action="/webdicegame/" method="get">
	<button type="submit">Custom Mode</button></form>
	<form name ="Random" action="/webdicegame/random" method ="post">
	<button type="submit">Random Mode</button>
	</form>
	<form name ="Score" action="/webdicegame/score" method ="post">
	<button type="submit">Score</button>
	</form>
	<input type=button value="Exit" onclick="self.close()">

</body>
</html>
