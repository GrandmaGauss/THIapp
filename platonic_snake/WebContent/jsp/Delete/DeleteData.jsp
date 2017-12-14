<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<title>Account</title>
</head>
<body>

<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
	<br>
</div>

<main>
	<div class = "ausrichtung">
		<div class = "formularfeld">
			<h1>Account löchen</h1>
			<form action="/platonic_snake/Delete">
			<p>Wollen Sie uns wirklich verlassen ? :(</p>
			<p>Bestätigen Sie bitte ihre Zugangsdaten.</p>
			<br>
			<label for = "username">Username:*</label>
			<input type="text" name="username" size=20 required><br>
			<br>
			<label for = "password">Password:*</label>
			<input type="text" name="password" size=20 required><br>
			<br>
			<input type="submit" value="Account löschen">
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
