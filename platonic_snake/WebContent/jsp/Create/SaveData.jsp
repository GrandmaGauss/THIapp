<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<title>Dein Profil</title>
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
			<base href="${pageContext.request.requestURI}" />
		<h1>Hier siehst du dein Profil. Viel Spaﬂ auf Platonic!</h1>
		<emp>Bild:</emp><img src = "/platonic_snake/BildServlet?username=${user.username}">
		
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Passwort</th>
				<th>Geburtstag</th>
				<th>Wohnort</th>
				<th>Interessen</th>
				
			</tr>
			
				<tr>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.birthday}</td>
					<td>${user.location}</td>
					<td>${user.interests}</td>
					
				</tr>

				</table>
		
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



