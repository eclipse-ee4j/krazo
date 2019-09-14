<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>CSRF Custom Exception Test</title>
</head>
<body>
<h1>CSRF Custom Exception Test</h1>
<form id="form" action="${mvc.uri('doPut')}" method="post" accept-charset="utf-8">

    <input type="hidden" name="_method" value="DELETE">

    <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>

    <input id="submit" type="submit" name="submit" value="Click here"/>
</form>
</body>
</html>
