<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
    <title>Form Validation</title>
</head>
<body>
    <h1>Form Validation</h1>
    <p>Name: ${mvc.encoders.html(data.name)}</p>
    <p>Age: ${data.age}</p>
</body>
</html>
