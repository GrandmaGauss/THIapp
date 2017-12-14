<!DOCTYPE html>
 +<HTML>
 +<head>
 +	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
 +	<title>Registrierung</title>
 +</head>
 +<BODY>
 +
 +<%@ includefile="/jsp/Fragments/header.jspf" %>
 +
 +<div class = "left">
 +<br>
 +</div>
 +<main>
 +	<div class = "ausrichtung">
 +		<div class = "formularfeld">
 +			<h2>Ausloggen</h2>
 +			<base href="${pageContext.request.requestURI}" />
 +			<form method = "get" action="/platonic_snake/LogoutServlet" >
 +		
 +			<label for = "Ausloggen"></label>
 +				<input type=SUBMIT name=Ausloggen>
 +			</form>
 +		</div>
 +	</div>
 +</main>
 +
 +<div class = "right">
 +<br>
 +</div>
 +<%@ includefile="/jsp/Fragments/footer.jspf" %>
 +</body>
 +</html> 
View    
35  platonic_snake/WebContent/jsp/LoggedOut.jsp
@@ -0,0 +1,35 @@
 +<!DOCTYPE html>
 +<HTML>
 +<head>
 +	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
 +	<title>Ausgeloggt</title>
 +</head>
 +<body>
 +
 +<%@ includefile="/jsp/Fragments/header.jspf" %>
 +<base href="${pageContext.request.requestURI}" />
 +
 +<div class = "left">
 +<br>
 +</div>
 +<main>
 +	<div class = "ausrichtung">
 +		<div class = "formularfeld">
 +			<h2>Du hast dich erfolgreich ausgeloggt</h2>
 +			
 +			Erfolgreich ausgeloggt<br>
 +			 <a href="index.jsp">Hier klicken um zur Startseite zu gelangen</a>
 +			</form>
 +		</div>
 +	</div>
 +</main>
 +
 +
 +
 +
 +<div class = "right">
 +<br>
 +</div>
 +<%@ includefile="/jsp/Fragments/footer.jspf" %>
 +</body>
 +</html>
