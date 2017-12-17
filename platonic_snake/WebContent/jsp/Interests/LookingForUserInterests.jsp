<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<meta charset="ISO-8859-1">
	<title>Nutzersuche</title>
</head>

<body>
<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
	<br>
</div>

<main>
	<div class = "ausrichtung">
		<div class = "formularfeld">
			<h2>Auf der Suche nach Menschen mit gleichen Interesse?</h2>
			<form method = "post" action ="/platonic_snake/Interests">
			<!--  <form method = "post" action ="/platonic_snake/Profil "> -->
				<label for = "interests">Interessen</label>
				<input type = text name = interests size=20><BR>
				<br>
				<input type = submit>
			</form>
		</div>
	</div>
</main>

<div class = "right">
	<br>
</div>

<%@ includefile="/jsp/Fragments/footer.jspf" %>
</body>
</html>