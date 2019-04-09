<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 07/04/2019
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Menu</title>
</head>
<body>
<%
    if (session.getAttribute("usuarioLogado") == null){
        response.sendRedirect("index.jsp");
    }
    out.print("Hola "+session.getAttribute("usuarioLogado"));
%>
<p>
    <a href="enviar.jsp">Enviar mensaje</a>
</p>
<p>
    <a href="gestion">Mostrar mensajes</a>
</p>
</body>
</html>
