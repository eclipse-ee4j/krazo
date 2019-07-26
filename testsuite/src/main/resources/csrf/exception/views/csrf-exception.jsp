<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>CSRF Custom Exception Test</title>
</head>
<body>
<h1>CSRF Custom Exception Test</h1>
<form id="form" action="csrf-exception" method="post" accept-charset="utf-8">
    <label>
        Greeting
        <input type="text" name="greeting" value="Hello!"/>
    </label>
    <input id="submit" type="submit" name="submit" value="Click here"/>
</form>
</body>
</html>
