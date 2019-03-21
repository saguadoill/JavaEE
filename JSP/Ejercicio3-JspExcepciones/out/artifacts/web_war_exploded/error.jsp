<%--
  Página que recoge el error del index y lo muestra por pantalla
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2> ERROR EN LA INTRODUCCION DE LOS DATOS</h2>
    <p>
        Los datos introducidos en el formulario no son correctos
    </p>

    <p>
    <% exception.printStackTrace(response.getWriter()); %>
    </p>
</body>
</html>
