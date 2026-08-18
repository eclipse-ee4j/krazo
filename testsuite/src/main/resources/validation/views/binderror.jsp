<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
    <title>Form Binding Error</title>
</head>
<body>
    <h1>Binding Error</h1>
    <p>Property: ${error.property}</p>
    <p>Param: ${error.param}</p>
    <p>Message: ${error.message}</p>
</body>
</html>
