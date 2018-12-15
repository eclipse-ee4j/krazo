<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>In Conversation</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
</head>
<body>
    <h1>In Conversation</h1>
    <p>Our Secret: ${bean.secret}</p></body>
    <p><a href="tellme?cid=${bean.id}">Continue Conversation</a></p>
    <p><a href="stop">Stop Conversation</a></p>
</html>
