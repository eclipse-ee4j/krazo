<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Default Extension Test</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
</head>
<body>
    <h1>Default Extension Test</h1>
    <p id="basePath">${mvc.basePath}</p>
    <p id="defaultExtension">${mvc.config.properties.get("org.eclipse.krazo.defaultViewFileExtension")}</p>
</body>
</html>
