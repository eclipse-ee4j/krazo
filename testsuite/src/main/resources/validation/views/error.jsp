<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
    <title>Form Validation</title>
</head>
<body>
    <h1>Form Error</h1>
    <p>Property: ${error.property}</p>
    <p>Param: ${error.param}</p>
    <p>Value: ${error.value}</p>
    <p>Message: ${error.message}</p>
</body>
</html>
