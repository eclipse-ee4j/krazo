<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
        <title>Validation</title>
    </head>
    <body>
        <h1>Validation</h1>
        <c:if test="${not empty errors}">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </c:if>
        <form name="form" method="POST"
              action="./validation?lang=${pageContext.request.parameterMap['lang'][0]}">
            <p>
                <label for="name">Name:</label>
                <input id="name" type="text" name="name"/>
            </p>
            <p>
                <input name="button" type="submit" value="Submit"/>
            </p>
        </form>
    </body>
</html>
