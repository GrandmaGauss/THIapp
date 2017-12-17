<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<title>Registrierung</title>
</head>
<body>

<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
<br>
</div>
<main>
	<div class = "ausrichtung">
		<div class = "formularfeld">
			<h2>Hier kannst du dein Profil verändern</h2>
			<base href="${pageContext.request.requestURI}" />
			<form action="/platonic_snake/changeUserServlet" method = "post" enctype = "multipart/form-data">
				<label for = "username">Wie lautet dein Username?</label>
				<input type=text name=username size=20><br>
				<br>
				<label for = "email">Willst du deine Email-Adresse verändern?</label>
				<input type=text name=email size=20><br>
				<br>
				<label for = "password">Oder lieber das Passwort?</label>
				<input type=text name = "password" id = "password" size=20><br>
				<br>
				<label for = "birthday">Dein Geburtsdatum?</label>
				<input type=date name=birthday><br>
				<br>
				<label for = "location">Bist du umgezogen?</label>
				<input type=text name=location size=20><br>
				<br>
				<label for = "interests">Hast du neue Hobbies für dich entdeckt?</label>
				<input type=text name=interests size=20><br>
				<br>
				<label for = "photo"> Foto: </label>
				<input type = file name = photo id ="photo" size=60 accept=image/*><br>
				<br>
				<label for = "Absenden"></label>
				<input type= submit name=Absenden>
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