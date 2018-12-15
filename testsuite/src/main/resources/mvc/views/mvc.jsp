<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Mvc Test</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
</head>
<body>
    <h1>Mvc Test</h1>
    <p id="basePath">${mvc.basePath}</p>
    <p id="csrf">${mvc.csrf.name}</p>
    <p id="encoders">${mvc.encoders.html("<&>")}</p>
    <p id="config">${mvc.config.properties.get("myproperty")}</p>
</body>
</html>
