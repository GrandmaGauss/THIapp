<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.requestURI}" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<title>Ciao</title>
</head>

<body>
<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
	<br>
</div>

<main>
	<div class = "ausrichtung">
		<div class = "ausgabefeld">
			<h1>Ciao ciao...</h1>
			<p>${username},</p>
			<p>Sie haben ihren Account erfolgreich gelöscht.</p>
			<p>Falls Sie es sich anders überlegen können Sie sich jederzeit neu <a href="../Create/GetData.jsp">Registrieren</a> ;)</p>
		</div>
	</div>
</main>

<div class = "right">
	<br>
</div>

<%@ includefile="/jsp/Fragments/footer.jspf" %>

</body>
</html>
