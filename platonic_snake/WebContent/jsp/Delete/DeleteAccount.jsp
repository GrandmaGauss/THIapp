<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<title>Registrierung</title>
	<base href="${pageContext.request.requestURI}" />
</head>
<body>

<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
<br>
</div>
<main>
	<div class = "ausrichtung">
		<div class = "formularfeld">
			<h2>Willst du uns wirklich verlassen?Das ist schade.
			Bitte gib deinen Usernamen und dein Passwort ein:</h2>
				<form action="/platonic_snake/Delete" method = "post" enctype = "multipart/form-data">
					<label for = "username">Username:*</label>
				<input type=text name=username size=20 required><br>
				<br>
				<label for = "password">Passwort:*</label>
				<input type=text name=password size=20 required><br>
				<br>
				<label for = "Absenden">* Pflichtfeld</label>
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



