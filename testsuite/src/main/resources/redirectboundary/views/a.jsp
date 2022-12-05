<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Redirect boundary test</title>
</head>
<body>
<h1>Page A</h1>

<p id="result">${redirectBeanValue}</p>

<form name="toAForm" action="${mvc.basePath}/a/toA" method="post">
    <button name="submit">Submit</button>
</form>

<form name="toBForm" action="${mvc.basePath}/a/toB" method="post">
    <button name="submit">Submit</button>
</form>
</body>
</html>
