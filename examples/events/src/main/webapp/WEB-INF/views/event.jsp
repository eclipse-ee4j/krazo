<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>MVC Events</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
</head>
<body>
    <h1>Event Information</h1>
    <div id="beforeControllerEvent">
        <h2>BeforeControllerEvent</h2>
        <p>Request URI: ${bean.beforeControllerEvent.uriInfo.requestUri}</p>
        <p>Controller Method: ${bean.beforeControllerEvent.resourceInfo.resourceMethod}</p>
    </div>
    <div id="afterControllerEvent">
        <h2>AfterControllerEvent</h2>
        <p>Request URI: ${bean.afterControllerEvent.uriInfo.requestUri}</p>
        <p>Controller Method: ${bean.afterControllerEvent.resourceInfo.resourceMethod}</p>
    </div>
    <div id="beforeProcessViewEvent">
        <h2>BeforeProcessViewEvent</h2>
        <p>View: ${bean.beforeProcessViewEvent.view}</p>
        <p>View Engine: ${bean.beforeProcessViewEvent.engine.name}</p>
    </div>
</body>
</html>
