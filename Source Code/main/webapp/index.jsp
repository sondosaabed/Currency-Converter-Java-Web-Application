<!DOCTYPE html>
<html>
<head>
<title>Data Source</title>
<style>
body {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
	margin: 0;
	padding: 0;
}

header {
	padding: 20px;
	background-color: whitesmoke;
	text-align: center;
}

main {
	max-width: 400px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 5px;
}

h1 {
	margin-top: 0;
}

form {
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 5px;
}

button {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	font-size: 16px;
	border: transparent;
	border-radius: 5px;
}

button {
	background-color: #FFCDBE;
	color: black;
	cursor: pointer;
	border: transparent;
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

header img {
	width: 150px;
	height: auto;
	display: block;
	margin: 0 auto;
}
</style>
</head>
<body>
	<header>
		<img src="images/logo.png" alt="Logo">
	</header>
	<main>
		<h1>Source of the data:</h1>
		<form method="post" id="source" action="converterForm.jsp">
			<button type="submit" name="source" value="db"
				onclick="setAction('db')">Database</button>
			<button type="submit" name="source" value="api"
				onclick="setAction('api')">API</button>
		</form>
	</main>

	<script>
	function setAction(source) {
	    var form = document.getElementById('source'); // Get the form        
	    if (source === 'api') {
	        form.action = 'converterForm.jsp?source=api';
	    } else {
	        form.action = 'converterForm.jsp?source=db';
	    } 
	}
  </script>
</body>
</html>