<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>CSRF Protection Test</title>
</head>
<body>
    <h1>CSRF Protection Test</h1>
    <form action="csrf" method="post" accept-charset="utf-8">
        <label>
            Greeting
            <input type="text" name="greeting" value="Hello!"/>
        </label>
        <input type="submit" name="submit" value="Click here"/>
        <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>
    </form>
</body>
</html>
