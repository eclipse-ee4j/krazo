<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Mixed resource test</title>
</head>
<body>
<p id="validation-performed">${validationPerformed}</p>

<form name="todoForm" action="${mvc.uri('create')}" method="post">
	<label for="title">Title</label>
	<input id="title" type="text" name="title">
	<br/>
	<label for="content">Content</label>
	<input id="content" type="text" name="content">
	<br/>
	<input type="submit" name="submit" value="Submit">
</form>
</body>
</html>
